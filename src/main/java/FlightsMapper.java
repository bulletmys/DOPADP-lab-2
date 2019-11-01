import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightsMapper extends Mapper<LongWritable, Text, KeyWritableComparable, Text> {
    private static int DEST_ID = 14;
    private static int FLIGHT_DELAY = 18;
    private static byte FLIGHT_INDICATOR = 1;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] strings = new CsvReader(value).getStrings();

        if (Integer.parseInt(strings[FLIGHT_DELAY]) != 0) {
            context.write(new KeyWritableComparable(Integer.parseInt(strings[DEST_ID]), FLIGHT_INDICATOR), new Text(strings[FLIGHT_DELAY]));
        }
    }
}