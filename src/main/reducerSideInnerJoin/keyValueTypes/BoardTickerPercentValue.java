package keyValueTypes;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

/*
 * custom value type for (key, value) pair output of one 
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
 
  public Text getBoardMember() {
	return boardMember;
  }

  public void setBoardMember(Text boardMember) {
  	this.boardMember = boardMember;
  }
  
  public DoubleWritable getPercentOwnership() {
  	return percentOwnership;
  }
  
  public void setPercentOwnership(DoubleWritable percentOwnership) {
  	this.percentOwnership = percentOwnership;
  }
  
  @Override
  public void readFields(DataInput in) throws IOException
  {
    boardMember.readFields(in);
    percentOwnership.readFields(in);	
  }
  
  @Override
  public void write(DataOutput out) throws IOException
  {
    boardMember.write(out);
    percentOwnership.write(out);;	
  }
}