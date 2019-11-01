import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class AirportMapper extends Mapper<LongWritable, Text, KeyWritableComparable, Text>{

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] strings = new CsvWritable(value).;
        context.write(new KeyWritableComparable());
    }
}
