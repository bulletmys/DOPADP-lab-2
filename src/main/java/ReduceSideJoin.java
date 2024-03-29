import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class ReduceSideJoin {
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println("Usage: WordCountApp <input path> <output path>");
            System.exit(-1);
        }
        System.out.println("BeforeJobSet");
        Job job = Job.getInstance();
        job.setJarByClass(ReduceSideJoin.class);
        job.setJobName("ReduceSideJoin");
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, AirportMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, FlightsMapper.class);
        System.out.println("MapDone");

        FileOutputFormat.setOutputPath(job, new Path(args[2]));

        job.setPartitionerClass(AirportIdPartitioner.class);
        job.setGroupingComparatorClass(AirportIdGroupComparator.class);
        job.setReducerClass(JoinReducer.class);

        job.setMapOutputKeyClass(KeyWritableComparable.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setNumReduceTasks(2);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
