//import org.apache.hadoop.io.RawComparator;
//import org.apache.hadoop.io.WritableComparator;
//
//import java.util.Comparator;
//
//public class AirportIdGroupComparator implements RawComparator<KeyWritableComparable> {
//
//    @Override
//    public int compare(byte[] bytes, int i, int i1, byte[] bytes1, int i2, int i3) {
//        return 0;
//    }
//
//    @Override
//    public int compare(KeyWritableComparable obj1, KeyWritableComparable obj2) {
//        return Integer.compare(obj1.getAirportId(), obj2.getAirportId());
//    }
//
//}

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AirportIdGroupComparator extends WritableComparator {

    protected AirportIdGroupComparator() {
        super(KeyWritableComparable.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        return Integer.compare(((KeyWritableComparable) a).getAirportId(), ((KeyWritableComparable) b).getAirportId());
    }
}