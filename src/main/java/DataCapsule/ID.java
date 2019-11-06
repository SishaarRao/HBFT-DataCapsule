package DataCapsule;

/**
 * Represents ID information pertaining to a DataCapsule
 */
public class ID {
    private int uid;

    public ID(int _uid) {
        uid = _uid;
    }

    @Override
    public String toString() {
        return Integer.toString(uid);
    }
}
