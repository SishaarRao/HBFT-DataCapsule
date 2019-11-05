package DataCapsule;

import java.util.*;
/**
 * Log object that manages all of the log entries for a DataCapsule object
 */
public class Log<T> {
    List<LogEntry> list;

    public Log() {
        list = new ArrayList<LogEntry>();
    }

    public T append(T obj) {
        list.add(new LogEntry(obj));
        return obj;
    }

    public int size() {
        return list.size();
    }

    public Iterator<LogEntry> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LogEntry entry : list) {
            sb.append(entry.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
