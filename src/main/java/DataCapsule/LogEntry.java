package DataCapsule;

import java.util.Date;

public class LogEntry<T> {
    private T obj;
    private Date timestamp;

    public LogEntry(T _obj) {
        obj = _obj;
        timestamp = new Date(System.currentTimeMillis());
    }

    public T get() {
        return obj;
    }

    @Override
    public String toString() {
        return String.format("%s --- %s", obj.toString(), timestamp.toString());
    }
}
