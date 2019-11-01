import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class JoinReducer extends Reducer<KeyWritableComparable, Text, Text, Text> {
    @Override
    protected void reduce(KeyWritableComparable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Text airportName = values.iterator().next();
        Iterator<Text> iterator = values.iterator();

        int sum = 0;

        while (iterator.hasNext()) {
            Text val = iterator.next();
            sum += val.toString()
        }
    }
}
