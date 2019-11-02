import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class KeyWritableComparable implements WritableComparable<KeyWritableComparable> {
    private int airportId;
    private byte indicator;

    KeyWritableComparable(int airportId, byte indicator) {
        this.airportId = airportId;
        this.indicator = indicator;
    }
    KeyWritableComparable() {
        airportId = 0;
        indicator = 0;
    }

    public int getAirportId() {
        return airportId;
    }

    @Override
    public int compareTo(KeyWritableComparable obj) {
        if (airportId > obj.airportId) {
            return 1;
        } else if (airportId == obj.airportId) {
            if (indicator > obj.indicator) {
                return 1;
            } else if (indicator == obj.indicator) {
                return 0;
            }
        }
        return -1;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.write(airportId);
        dataOutput.write(indicator);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        airportId = dataInput.readInt();
        indicator = dataInput.readByte();
    }
}
