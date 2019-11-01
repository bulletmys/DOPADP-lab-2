import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AirportIdPartitioner extends Partitioner<KeyWritableComparable, Text> {

    @Override
    public int getPartition(KeyWritableComparable obj, Text text, int i) {
        return (Integer.valueOf(obj.getAirportId()).hashCode() & Integer.MAX_VALUE) % i;
    }
}
