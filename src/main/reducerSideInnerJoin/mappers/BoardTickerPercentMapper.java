package mappers;

import java.io.IOException;

import keyValueTypes.BoardTickerPercentValue;
import keyValueTypes.MRjoinSharedKey;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class BoardTickerPercentMapper extends
  Mapper<LongWritable, Text, MRjoinSharedKey, BoardTickerPercentValue>
{
  public void map(LongWritable lineOffset, Text row,
    Context context) throws IOException, InterruptedException
  {
    /*
     * CSV file as input, if file uses other delimiters
     * such as pipe ("|") or tab ("\t") then line should
     * be split with the other delimiters
     */
    String [] tokenizedRow = row.toString().split(",");
    
    String ticker = tokenizedRow[0];
    String boardMember = tokenizedRow[1];
    String percentOwnership = tokenizedRow[2];
    
    MRjoinSharedKey key = new MRjoinSharedKey(ticker, 1);
    BoardTickerPercentValue value = new BoardTickerPercentValue (
      boardMember, Double.valueOf(percentOwnership));
    
    context.write(key, value);
  }
}
