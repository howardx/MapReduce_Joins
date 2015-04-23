package keyValueTypes;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

public class TickerPriceVolumeValue implements Writable
{
  private DoubleWritable price = new DoubleWritable();
  private IntWritable volume = new IntWritable();
  private Text date = new Text();

  public TickerPriceVolumeValue() {};

  public TickerPriceVolumeValue(double p, int v, String d)
  {
    price.set(p);
    volume.set(v);
    date.set(d.getBytes());
  }

  public Text getDate() {
	return date;
  }

  public void setDate(Text date) {
  	this.date = date;
  }
  
  public DoubleWritable getPrice() {
	return price;
  }
  
  public void setPrice(DoubleWritable price) {
  	this.price = price;
  }
  
  public IntWritable getVolume() {
  	return volume;
  }
  
  public void setVolume(IntWritable volume) {
  	this.volume = volume;
  }
  
  @Override
  public void readFields(DataInput in) throws IOException
  {
    price.readFields(in);
    volume.readFields(in);
    date.readFields(in);
  }
  
  @Override
  public void write(DataOutput out) throws IOException
  {
  	price.write(out);
  	volume.write(out);
  	date.write(out);
  }
}