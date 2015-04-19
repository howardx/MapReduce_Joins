package reducer;

import keyValueTypes.MultiMapperValue;
import keyValueTypes.TickerDateRecordKey;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends 
  Reducer <TickerDateRecordKey, Iterable<MultiMapperValue>, Text, Text>
{

}
