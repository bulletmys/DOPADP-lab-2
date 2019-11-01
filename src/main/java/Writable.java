import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CsvWritable implements Writable {

    private Text str = new Text();
    String[] strings;

    private void makeStrings() {
        strings = str.toString().split()
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeBytes(
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        str.readFields(dataInput);
    }
}
