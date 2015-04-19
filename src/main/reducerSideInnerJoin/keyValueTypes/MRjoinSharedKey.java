package keyValueTypes;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

/*
 * As joining 2 datasets, there must be a key (primary/foreign)
 * that's common in the 2 datasets.
 * 
 * Hence the Key type could be shared by both mappers
 */

public class MRjoinSharedKey implements
  WritableComparable<MRjoinSharedKey>
{
  private Text ticker = new Text();
  
  private IntWritable comingFromRecord = new IntWritable();

  /*****************************************************
   * NEED a default constructor (no input args)
   */
  public MRjoinSharedKey () {}
  
  public MRjoinSharedKey (String stockTicker,
    int recordID)
  {
    ticker.set(stockTicker.getBytes());
    comingFromRecord.set(recordID);
  }
 
  @Override
  public int compareTo(MRjoinSharedKey compare)
  {
    return ticker.compareTo((compare.getTicker()));
  };
  
  /*
   * will be used by partitioner, and we want to partition 
   * mapper output base on ticker ONLY, hence for this method
   */
  @Override
  public int hashCode()
  {
    return ticker.hashCode();
  }
 
  public boolean equals(MRjoinSharedKey other)
  {
    return ticker.equals(other.getTicker())
      && comingFromRecord.equals(other.getComingFromRecord());
  }
 
  @Override
  public void readFields(DataInput in) throws IOException
  {
    ticker.readFields(in);
    comingFromRecord.readFields(in);
  }
  
  @Override
  public void write(DataOutput out) throws IOException
  {
    ticker.write(out);
    comingFromRecord.write(out);
  }

  public Text getTicker() {
  	return ticker;
  }
  
  public void setTicker(Text ticker) {
  	this.ticker = ticker;
  }

  public IntWritable getComingFromRecord() {
  	return comingFromRecord;
  }
  
  public void setComingFromRecord(IntWritable comingFromRecord) {
  	this.comingFromRecord = comingFromRecord;
  }
}