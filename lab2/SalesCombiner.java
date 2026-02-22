import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

// same as reducer
public class SalesCombiner
        extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    public void reduce(Text date, Iterable<IntWritable> sales, Context context)
            throws IOException, InterruptedException {
        int total = 0;
        for(IntWritable sale: sales){
            total += sale.get();
        }
        context.write(date, new IntWritable(total));
    }
}
