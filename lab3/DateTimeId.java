import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DateTimeId implements Writable, WritableComparable<DateTimeId>{
    private final Text date = new Text();
    private final Text time = new Text();
    private final IntWritable id = new IntWritable();

    public DateTimeId() {

    }
    
    public DateTimeId(String date, String time, int id) {
        this.date.set(date);
        this.time.set(time);
        this.id.set(id);
    }

    @Override
    public void write(DataOutput out) throws IOException {
        date.write(out);
        time.write(out);
        id.write(out);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        date.readFields(in);
        time.readFields(in);
        id.readFields(in);
    }

    @Override
    public int compareTo(DateTimeId other) {
        int result = date.compareTo(other.date);
        if (result == 0) {
            return time.compareTo(other.time);
        }
        return result;
    }

    public Text getDate() {
        return date;
    }

    public Text getTime() {
        return time;
    }

    public IntWritable getId() {
        return id;
    }
}
