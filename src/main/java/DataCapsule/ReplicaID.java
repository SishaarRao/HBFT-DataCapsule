package DataCapsule;

/**
 * Represents ReplicaID information pertaining to a DataCapsule
 */
public class ReplicaID {
    private int uid;

    public ReplicaID(int _uid) {
        uid = _uid;
    }

    @Override
    public String toString() {
        return Integer.toString(uid);
    }
}
