import org.apache.hadoop.mapred.lib.MultipleInputs;
import org.apache.hadoop.mapreduce.Job;

public class ReduceSideJoin {
    public static void main(String[] args) throws Exception {
        Job job = Job.getInstance();
        job.setJarByClass(ReduceSideJoin.class);
        job.setJobName("ReduceSideJoin");
        MultipleInputs.addInputPath(job, );
    }
}
