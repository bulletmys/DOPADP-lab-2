import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class JoinReducer extends Reducer<KeyWritableComparable, Text, Text, Text> {
    @Override
    protected void reduce(KeyWritableComparable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator<Text> iterator = values.iterator();
        Text airportName = new Text(iterator.next());

        float sum = 0, max = Float.MIN_VALUE, min = Float.MAX_VALUE, counter = 0;

        while (iterator.hasNext()) {
            Text val = iterator.next();
            float elem = Float.parseFloat(val.toString());
            sum += elem;
            if (elem > max) {
                max = elem;
            }

            if (elem < min) {
                min = elem;
            }

            counter++;
        }
        if (counter != 0)
            context.write(airportName, new Text("Min = " + min + ", Max = " + max + " Average = " + sum / counter));
    }
}
