package HotStuff;

import DataCapsule.ID;

/**
 * Represents ReplicaID information pertaining to a HBFT Instance
 */
public class ReplicaID {
    private ID data_id;
    private int replica_id;

    public ReplicaID(int _replica_id, ID _data_id) {
        data_id = _data_id;
        replica_id = _replica_id;
    }

    public ID dataID() {
        return data_id;
    }

    public int replicaID() {
        return replica_id;
    }

    @Override
    public String toString() {
        return String.format("Replica:%s, DataCapsule:%s\n", data_id.toString(), Integer.toString(replica_id));
    }
}
