package HotStuff;

import DataCapsule.*;
import javafx.util.Pair;

import java.util.List;

/**
 * Core implementation of HotStuff
 * Can be treated as the underlying API that will be exposed to the network client
 */
public class HotStuffCore {
    Block genesis;                                // Genesis DataCapsule (init)

    /** State Variables **/
    Pair<DataCapsule, QuorumCertificate> highestQC;     // Highest Quorum Certificate
    Block locked;                                 // Locked proposal
    Block lastCommited;                           // Last Committed Proposal
    int lastCommittedSize;                              // Size of last committed proposal
    ReplicaID id;                                       // ID of this particular replica
    Block data;                                   // Underlying DataCapsule object

    public HotStuffCore(ReplicaID replicaID) {
        id = replicaID;
        genesis = new Block(true, 1);
        locked = genesis;
        lastCommited = genesis;
        lastCommittedSize = genesis.size();
        data.append(genesis);
    }

    /**
     * Call to inform the state machine that a datacapsule is ready to be handled.
     * A datacapsule is only delivered if itself is fetched, the datacapsule for the
     * contained qc is fetched and all parents are delivered. The user should
     * always ensure this invariant. The invalid blocks will be dropped by this
     * function.
     * @param capsule
     * @return true if valid
     */
    public boolean on_deliver(DataCapsule capsule) {
        return false;
    }

    /**
     * Call upon the delivery of a proposal message.
     * The block mentioned in the message should be already delivered.
     * @param proposal
     */
    public void on_receive_proposal(Proposal proposal) {
        return;
    }

    /**
     * Call upon the delivery of a vote message.
     * The block mentioned in the message should be already delivered.
     * @param vote
     */
    public void on_receive_vote(Vote vote) {
        return;
    }

    /**
     * Call to submit new commands to be decided (executed). "Parents" must
     * contain at least one block, and the first block is the actual parent,
     * while the others are uncles/aunts
     * @return
     */
    public DataCapsule on_propose(DataCapsule proposalData, List<DataCapsule> parents) {
        return proposalData;
    }

    /** Called by HotStuffCore upon the decision being made for cmd
     * @param commit
     */
    public void do_decide(Commit commit) {
        return;
    }

    public void do_consensus(DataCapsule capsule) {
        return;
    }

    /**
     * Called by HotStuffCore upon broadcasting a new proposal.
     * The user should send the proposal message to all replicas except for
     * itself.
     * @param proposal
     */
    public void do_broadcast_proposal(Proposal proposal) {
        return;
    }

    /**
     * Called upon sending out a new vote to the next proposer.  The user
     * should send the vote message to a *good* proposer to have good liveness,
     * while safety is always guaranteed by HotStuffCore.
     * @param last_proposer
     * @param vote
     */
    public void do_vote(ReplicaID last_proposer, Vote vote) {

    }

    /**
     * Create a quorum certificate that proves 2f+1 votes for a block.
     * @param data
     * @return
     */
    public QuorumCertificate create_quorum_cert(DataCapsule data) {
        return null;
    }

    /**
     * Create a quorum certificate from its serialized form
     * @param dataSerialized
     * @return
     */
    public QuorumCertificate create_quorum_cert(String dataSerialized) {
        return null;
    }

    /**
     * Add a replica to the current configuration. This should only be called
     * before running HotStuffCore protocol.
     * @param rid
     * @param address
     */
    public void addReplica(ReplicaID rid, Address address) {
        return;
    }

    /**
     * Try to prune blocks lower than last committed height - staleness.
     * @param staleness
     */
    public void prune(int staleness) {
        return;
    }

    public Block get_genesis() {
        return genesis;
    }

    public DataCapsule getHighestQC() {
        return highestQC.getKey();
    }
}
