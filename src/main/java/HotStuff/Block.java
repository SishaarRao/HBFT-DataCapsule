package HotStuff;

import DataCapsule.DataCapsule;
import com.google.gson.Gson;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Represents a Block in our HBFT
 */
public class Block {
    List<String> parent_hashes;
    DataCapsule data;
    QuorumCertificate qc;

    String hash;
    List<DataCapsule> parents;
    DataCapsule qc_ref;
    QuorumCertificate self_qc;
    int height;
    boolean delivered;
    int decision;

    Set<ReplicaID> voted;

    public Block() {
        qc = null;
        qc_ref = null;
        self_qc = null;
        height = 0;
        delivered = false;
        decision = 0;
        voted = new HashSet<ReplicaID>();
    }

    public Block(boolean _delivered, int _decision) {
        qc = null;
        hash = DigestUtils.sha256Hex(this.toString());
        qc_ref = null;
        self_qc = null;
        height = 0;
        delivered = _delivered;
        decision = _decision;
        voted = new HashSet<ReplicaID>();
    }

    public Block(DataCapsule data,
                 QuorumCertificate qc,
                 List<DataCapsule> parents,
                 DataCapsule qc_ref,
                 QuorumCertificate self_qc,
                 int height,
                 int decision) {
        parent_hashes = getHashes(parents);
        this.data = data;
        this.qc = qc;
        this.parents = parents;
        this.qc_ref = qc_ref;
        this.self_qc = self_qc;
        this.height = height;
        this.decision = decision;
        this.hash = DigestUtils.sha256Hex(this.toString());
        voted = new HashSet<ReplicaID>();

    }

    public List<String> getHashes(List<DataCapsule> parents) {
        List<String> hashes = new ArrayList<String>(parents.size());
        for (DataCapsule capsule : parents) {
            hashes.add(DigestUtils.sha256Hex(capsule.toString()));
        }
        return hashes;
    }

    public int size() {
        return data.size();
    }

    public void append(Block block) {
        append(block.data);
    }

    public void append(DataCapsule capsule) {
        data.append(capsule);
    }


    public Block parse(String json) { return (new Gson()).fromJson(json, Block.class); }

    @Override
    public String toString() { return (new Gson()).toJson(this); }
}
