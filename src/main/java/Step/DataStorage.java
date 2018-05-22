package Step;

public class DataStorage {
    Object value;
    long timeSt;

    public DataStorage(Object value) {
        this.value = value;
        this.timeSt = System.currentTimeMillis();
    }

    public Object getValue() {
        return value;
    }

    public long getTimeSt() {
        return timeSt;
    }
}
