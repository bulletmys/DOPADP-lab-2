import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CsvWritable implements Writable {

    private Text str = new Text();
    private String[] strings;

    private void makeStrings() {
        strings = str.toString().replaceAll("\"", "").split(",");
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        for (String str : strings) {
            dataOutput.writeBytes(str);
        }
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        str.readFields(dataInput);
    }
}
