package mappers;

import java.io.IOException;

import keyValueTypes.MRjoinSharedKey;
import keyValueTypes.TickerPriceVolumeValue;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TickerPriceVolumeMapper extends
  Mapper<LongWritable, Text, MRjoinSharedKey, TickerPriceVolumeValue>
{
  public void map(LongWritable lineOffset, Text row,
    Context context) throws IOException, InterruptedException
  {
    String [] tokenizedRow = row.toString().split(",");
    
    String ticker = tokenizedRow[0];
    String price = tokenizedRow[1];
    String date = tokenizedRow[2];
    String volume = tokenizedRow[3];
    
    MRjoinSharedKey key = new MRjoinSharedKey(ticker, 2);
    
    TickerPriceVolumeValue value = new TickerPriceVolumeValue (
      Double.valueOf(price), Integer.valueOf(volume), date);
    
    context.write(key, value);
  }
}
