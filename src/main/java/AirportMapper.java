import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class AirportMapper extends Mapper<LongWritable, Text, KeyWritableComparable, Text> {
    private static int AIRPORT_ID = 0;
    private static int AIRPORT_NAME = 1;
    private static byte AIRPORT_INDICATOR = 0;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        System.out.println("BeforeAirportMapper");
        String[] strings = new CsvReader(value).getStrings();

        if (!strings[AIRPORT_ID].equals("Code")) {
            context.write(new KeyWritableComparable(Integer.parseInt(strings[AIRPORT_ID]), AIRPORT_INDICATOR), new Text(strings[AIRPORT_NAME]));
        }
        System.out.println("AfterAirportMapper");
    }
}