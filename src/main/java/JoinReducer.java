import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class JoinReducer extends Reducer<KeyWritableComparable, Text, Text, Text> {
    @Override
    protected void reduce(KeyWritableComparable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Text airportName = values.
    }
}
