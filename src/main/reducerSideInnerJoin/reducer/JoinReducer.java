package reducer;

import keyValueTypes.BoardTickerPercentValue;
import keyValueTypes.MRjoinSharedKey;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends 
  Reducer <MRjoinSharedKey, Iterable<BoardTickerPercentValue>, Text, Text>
{

}
