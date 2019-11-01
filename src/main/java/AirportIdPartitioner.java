import org.apache.hadoop.mapreduce.Partitioner;

public class AirportIdPartitioner extends Partitioner<KeyWritableComparable, Text> {

    @Override
    public int getPartition(KeyWritableComparable keyWritableComparable, Text text, int i) {
        return 0;
    }
}
