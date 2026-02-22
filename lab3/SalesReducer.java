import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.Reducer.*;

public class SalesReducer
        extends Reducer<DateTimeId, Text, Text, Text> {

    @Override
    public void reduce(DateTimeId comp, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        String result = "";
        for (Text value : values) {
            result += (value.toString() + ", ");
        }
        result = result.substring(0, result.length() - 2);
        context.write(comp.getDate(), new Text(result));
    }
}
