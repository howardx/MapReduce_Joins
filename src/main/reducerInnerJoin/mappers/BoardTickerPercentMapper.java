package mappers;

import keyValueTypes.MultiMapperValue;
import keyValueTypes.TickerDateRecordKey;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class BoardTickerPercentMapper extends
  Mapper<Text, Text, TickerDateRecordKey, MultiMapperValue>
{

}
