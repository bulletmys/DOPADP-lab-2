import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class KeyWritableComparable implements WritableComparable<KeyWritableComparable> {
    int airportId;
    byte 

    @Override
    public int compareTo(KeyWritableComparable keyWritableComparable) {
        return 0;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {

    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

    }
}
