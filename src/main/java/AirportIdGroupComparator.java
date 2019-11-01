import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparator;

import java.util.Comparator;

public class AirportIdGroupComparator implements RawComparator {

    @Override
    public int compare(byte[] bytes, int i, int i1, byte[] bytes1, int i2, int i3) {
        return 0;
    }

    @Override
    public int compare(Object o, Object t1) {
        return 0;
    }
}
