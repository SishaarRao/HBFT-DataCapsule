package DataCapsule;

import java.util.*;
/**
 * Wrapper class that represents the DataCapsule API.
 * DataCapsules are secure, append-only, versioned logs
 */

public class DataCapsule<T> {
    private int uid;
    private Log<T> log;

    public DataCapsule(int _uid) {
        this.uid = _uid;
        log = new Log<T>();
    }

    public T append(T obj) {
        return log.append(obj);
    }

    public Iterator<T> iterator() {
        return new DataCapsuleIterator<T>();
    }

    public class DataCapsuleIterator<T> implements Iterator<T> {
        Iterator<LogEntry> iterator;
        DataCapsuleIterator() {
            iterator = log.iterator();
        }

        public T next() {
            LogEntry next = iterator.next();
            return (T) next.get();
        }

        public boolean hasNext() { return iterator.hasNext(); }
        public void remove() { throw new UnsupportedOperationException(); }
    }

    public String toString() {
        return String.format("-----%d-----\n%s", uid, log.toString());
    }
}
