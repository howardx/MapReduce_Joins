package reducer;

import keyValueTypes.MRjoinSharedKey;
import keyValueTypes.ReducerGenericValue;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends 
  Reducer <MRjoinSharedKey, Iterable<ReducerGenericValue>, Text, Text>
{

}
