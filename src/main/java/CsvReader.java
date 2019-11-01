import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CsvReader {

    private String[] strings;

    CsvReader(Text text) {
        strings = text.toString().replaceAll("\"", "").split(",");
    }

    public String[] getStrings() {
        return strings;
    }
}
