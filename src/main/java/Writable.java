import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CsvWritable implements Writable {

    String[] str;

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        for (String string : str) {
            dataOutput.writeBytes(string);
        }
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        str = dataInput.
    }
}
