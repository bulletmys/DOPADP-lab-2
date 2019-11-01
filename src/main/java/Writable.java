import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CsvWritable implements Writable {

    String[] str;

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(str);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

    }
}
