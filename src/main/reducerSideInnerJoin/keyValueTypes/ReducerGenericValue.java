package keyValueTypes;

import org.apache.hadoop.io.GenericWritable;
import org.apache.hadoop.io.Writable;

/*
 * Since 2 mappers emit different classes as their values
 * the reducer needs a generic/parent type to hold them
 * 
 * Hadoop provides GenericWritable class that can wrap the classes
 * emitted by multiple mappers
 */

public class ReducerGenericValue extends GenericWritable
{
  private static Class<? extends Writable> [] VALUECLASSES = null;

  /*
   * GenericWritable is used by extending it and overriding
   * getTypes() method that tells which types will be wrapped.
   * 
   * All the types specified here must implement Writable.
   */
  static
  {
    VALUECLASSES = ( Class<? extends Writable> [] ) new Class []
    {
      BoardTickerPercentValue.class,
      TickerPriceVolumeValue.class
    };
  }
 
  public ReducerGenericValue() {};
 
  public ReducerGenericValue(Writable instance)
  {
    set(instance);
  }

  @Override
  protected Class<? extends Writable>[] getTypes()
  {
    return VALUECLASSES;
  }
}