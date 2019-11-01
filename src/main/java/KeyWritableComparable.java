import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class KeyWritableComparable implements WritableComparable<KeyWritableComparable> {
    private int airportId;
    private byte indicator;

    @Override
    public int compareTo(KeyWritableComparable keyWritableComparable) {
        if (airportId > keyWritableComparable.airportId) {
            return 1;
        } else if (airportId == keyWritableComparable.airportId) {
            if (indicator > keyWritableComparable.indicator) {
                return 1;
            } else if (indicator == keyWritableComparable.indicator) {
                return 0;
            }
        }
        return -1;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

    }
}
