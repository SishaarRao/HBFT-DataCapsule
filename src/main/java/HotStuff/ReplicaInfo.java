package HotStuff;

/**
 * Metadata regarding the Replica itself
 */
public class ReplicaInfo {
    ReplicaID id;
    Address address;

    public ReplicaInfo(ReplicaID _id, Address _address) {
        id = _id;
        address = _address;
    }
}
