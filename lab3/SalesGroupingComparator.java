import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class SalesGroupingComparator extends WritableComparator {

    protected SalesGroupingComparator() {
        super(DateTimeId.class, true);
    }
    
    @Override
    public int compare(WritableComparable wc1, WritableComparable wc2) {
        DateTimeId comp1 = (DateTimeId) wc1;
        DateTimeId comp2 = (DateTimeId) wc2;
        return comp1.getDate().compareTo(comp2.getDate());
    }
}
