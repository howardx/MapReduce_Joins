package mappers;

import keyValueTypes.MRjoinSharedKey;
import keyValueTypes.TickerPriceVolumeValue;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TickerPriceVolumeMapper extends
  Mapper<LongWritable, Text, MRjoinSharedKey, TickerPriceVolumeValue>
{

}
