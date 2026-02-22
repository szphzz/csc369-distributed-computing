import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.Mapper.*;
import org.apache.log4j.Logger;

public class SalesMapper
        extends Mapper<LongWritable, Text, DateTimeId, Text> {
    private static Logger THE_LOGGER = Logger.getLogger(TotalSalesDriver.class);

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        THE_LOGGER.debug("I AM IN LOGGER");
        String valueAsString = value.toString().trim();
        String[] tokens = valueAsString.split(", ");
        if (tokens.length != 5) {
            return;
        }
        context.write(new DateTimeId(tokens[1], tokens[2], Integer.parseInt(tokens[0])), 
        new Text(tokens[2] + " " + tokens[0]));
        // single write, but we can have multiple writes to context
    }
}