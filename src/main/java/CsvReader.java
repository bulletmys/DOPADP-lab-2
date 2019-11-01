import org.apache.hadoop.io.Text;


public class CsvReader {

    private String[] strings;

    CsvReader(Text text) {
        strings = text.toString().replaceAll("\"", "").split(",");
    }

    public String[] getStrings() {
        return strings;
    }
}
