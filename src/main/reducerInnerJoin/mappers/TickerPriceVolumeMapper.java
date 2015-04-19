package mappers;

import keyValueTypes.MultiMapperValue;
import keyValueTypes.TickerDateRecordKey;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TickerPriceVolumeMapper extends
  Mapper<LongWritable, Text, TickerDateRecordKey, MultiMapperValue>
{

}
