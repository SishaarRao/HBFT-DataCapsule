package DataCapsule;

import java.util.*;
/**
 * Wrapper class that represents the DataCapsule API.
 * DataCapsules are secure, append-only, versioned logs
 */

public class DataCapsule<T> {
    private static int global_id_counter = 0;
    private ID id;
    private Log<T> log;

    public DataCapsule() {
        id = new ID(global_id_counter);
        log = new Log<T>();
        global_id_counter++;
    }
    public DataCapsule(ID _uid) {
        id = _uid;
        log = new Log<T>();
    }

    public T append(T obj) {
        return log.append(obj);
    }

    public DataCapsule append(DataCapsule<T> obj) {
        Iterator<T> iter = obj.iterator();
        while (iter.hasNext()) {
            append(iter.next());
        }
        return this;
    }

    public int size() {
        return log.size();
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
        return String.format("-----%s-----\n%s", id.toString(), log.toString());
    }
}
