import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class SalesPartitioner extends Partitioner<DateTimeId, Text> {
    
    @Override
    public int getPartition(DateTimeId comp, Text timeId, int numberOfPartitions) {
        return Math.abs(comp.getDate().hashCode() % numberOfPartitions);
    }
}
