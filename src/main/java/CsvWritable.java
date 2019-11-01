import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CsvWritable implements Writable {

    private Text text = new Text();
    private String[] strings;

    CsvWritable(Text text) {
        text
    }

    private void makeStrings() {
        strings = text.toString().replaceAll("\"", "").split(",");
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        for (String str : strings) {
            dataOutput.writeBytes(str);
        }
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        text.readFields(dataInput);
        makeStrings();
    }
}
