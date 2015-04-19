package keyValueTypes;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TickerDateRecordKey extends
  Mapper<LongWritable, Text, TickerDateRecordKey, MultiMapperValue>
{

}
