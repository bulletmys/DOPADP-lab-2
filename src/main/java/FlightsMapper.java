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
        System.out.println("BeforeFlightMapper");
        String[] strings = new CsvReader(value).getStrings();

        if (!strings[DEST_ID].equals("DEST_AIRPORT_ID") && !strings[FLIGHT_DELAY].equals("ARR_DELAY_NEW") && Float.parseFloat(strings[FLIGHT_DELAY]) != 0.0) {
            context.write(new KeyWritableComparable(Math.round(Float.parseFloat(strings[DEST_ID])), FLIGHT_INDICATOR), new Text(strings[FLIGHT_DELAY]));
        }
        System.out.println("AfterFlightMapper");
    }
}
