package HotStuff;

import DataCapsule.*;
import javafx.util.Pair;

/**
 * Core implementation of HotStuff
 * Can be treated as the underlying API that will be exposed to the network client
 */
public class HotStuffCore {
    DataCapsule genesis;

    /** State Variables **/
    Pair<DataCapsule, QuorumCertificate> highestQC;     // Highest Quorum Certificate
    DataCapsule locked;                                 // Locked proposal
    DataCapsule lastCommited;                           // Last Committed Proposal
    int lastCommittedSize;                              // Size of last committed proposal
    ReplicaID id;                                       // ID of this particular replica
    DataCapsule data;                                   // Underlying DataCapsule object

    public HotStuffCore(ReplicaID replicaID) {
        id = replicaID;
        genesis = new DataCapsule(id.dataID());
        locked = genesis;
        lastCommited = genesis;
        lastCommittedSize = genesis.size();
        data.append(genesis);
    }
    
}
