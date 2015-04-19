package jobDriver;

import keyValueTypes.BoardTickerPercentValue;
import keyValueTypes.MRjoinSharedKey;
import mappers.BoardTickerPercentMapper;
import mappers.TickerPriceVolumeMapper;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import reducer.JoinReducer;

/*
 * JOIN during the REDUCE phase of Map-Reduce application.
 *   -- reduce side join
 *   
 * This technique is recommended when both datasets are large.
 * Both will be mapped/distributed over the network/cluster
 *   -- low performance
 */

public class JoinRunner extends Configured implements Tool
{
  public int run(String[] allArgs) throws Exception
  {
    String[] args = new GenericOptionsParser(getConf(), allArgs).getRemainingArgs();
                               
    Job job = new Job(getConf(), "Map Reduce Innter Join on Reducer side");
    job.setJarByClass(JoinRunner.class);
                               
    job.setInputFormatClass(TextInputFormat.class);
    job.setOutputFormatClass(TextOutputFormat.class);
                               
    job.setMapOutputKeyClass(MRjoinSharedKey.class);
    job.setMapOutputValueClass(BoardTickerPercentValue.class);
    
    MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, TickerPriceVolumeMapper.class);
    MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, BoardTickerPercentMapper.class);
                              
    job.setReducerClass(JoinReducer.class);
     
    // USEFUL !
    //job.setSortComparatorClass(JoinSortingComparator.class);
    //job.setGroupingComparatorClass(JoinGroupingComparator.class);
                               
    job.setOutputKeyClass(NullWritable.class);
    job.setOutputValueClass(Text.class);
                               
    FileOutputFormat.setOutputPath(job, new Path(allArgs[2]));
    boolean status = job.waitForCompletion(true);
    if (status) {
        return 0;
    } else {
        return 1;
    }             
  }

  @Override
  public Configuration getConf()
  {
  	return null;
  }
  
  @Override
  public void setConf(Configuration arg0) {}
  
  public static void main(String[] args) throws Exception
  {
    Configuration conf = new Configuration();
    int res = ToolRunner.run(new JoinRunner(), args);
  }
  
}
