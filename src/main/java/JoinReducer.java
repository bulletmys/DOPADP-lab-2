import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class JoinReducer extends Reducer<KeyWritableComparable, Text, Text, Text> {
    @Override
    protected void reduce(KeyWritableComparable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Text airportName = values.iterator().next();
        Iterator<Text> iterator = values.iterator();

        int sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, counter = 0;

        while (iterator.hasNext()) {
            Text val = iterator.next();
            int elem = Integer.parseInt(val.toString());
            sum += elem;
            if (elem > max) {
                max = elem;
            }

            if (elem < min) {
                min = elem;
            }

            counter++;
        }

        context.write(airportName, new Text("Min = " + min + ", Max = " + max + " Average = " + sum / counter));
    }
}
