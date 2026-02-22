import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

// don't need a sorting comparator when just simply calls compareTo() of custom class
// example of when we would need: want to sort integers in descending order
public class SalesSortingComparator extends WritableComparator {
    
    protected SalesSortingComparator() {
        super(DateTimeId.class, true);
    }
    
    @Override
    public int compare(WritableComparable wc1, WritableComparable wc2) {
        DateTimeId comp1 = (DateTimeId) wc1;
        DateTimeId comp2 = (DateTimeId) wc2;
        return comp1.compareTo(comp2);
    }
}