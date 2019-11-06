package HotStuff;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration details for all the replicas
 */
public class ReplicaConfig {
    Map<ReplicaID, ReplicaInfo> replica_map;
    int nreplicas;
    int majority;

    public ReplicaConfig() {
        nreplicas = 0;
        majority = 0;
        replica_map = new HashMap<ReplicaID, ReplicaInfo>();
    }

    public ReplicaInfo get_info(ReplicaID rid) throws HotStuffException {
        if (!replica_map.containsKey(rid)) {
            throw new HotStuffException("Replica does not exist: " + rid.toString());
        }
        return replica_map.get(rid);
    }

    public Address get_addr(ReplicaID rid) throws HotStuffException {
        return get_info(rid).address;
    }
}
