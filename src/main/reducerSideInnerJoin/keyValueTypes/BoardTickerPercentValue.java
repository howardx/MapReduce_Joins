package keyValueTypes;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

/*
 * custom value type for (key, value) pair output of 1 
 * particular mapper class out of the 2 mapper classes
 * associated with Map Reduce JOIN
 */
public class BoardTickerPercentValue implements Writable
{
  private Text boardMember = new Text();
  private DoubleWritable percentOwnership = new DoubleWritable();

  public BoardTickerPercentValue() {};
  
  public BoardTickerPercentValue(String board, double percent)
  {
    boardMember.set(board.getBytes());
    percentOwnership.set(percent);
  }
  
  @Override
  public void readFields(DataInput in) throws IOException
  {
  	
  }
  
  @Override
  public void write(DataOutput out) throws IOException
  {
  	
  }
}