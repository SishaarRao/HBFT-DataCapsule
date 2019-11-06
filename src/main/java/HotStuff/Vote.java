package HotStuff;

import DataCapsule.*;
import com.google.gson.Gson;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Represents a vote cast by a particular replica on a given proposal of changes
 *
 * Currently there is no cryptographically guaranteed approval or rejection (e.g. assume no malicious intent on votes)
 *
 */
public class Vote {
    ReplicaID id;
    private final String DATA_HASH;
    boolean inFavor = false;

    public Vote(ReplicaID _id, DataCapsule data) {
        id = _id;
        DATA_HASH = DigestUtils.sha256Hex(data.toString());
    }

    public Vote approve() {
        inFavor = true;
        return this;
    }

    public Vote reject() {
        inFavor = false;
        return this;
    }

    public Vote parse(String json) { return (new Gson()).fromJson(json, Vote.class); }

    @Override
    public String toString() { return (new Gson()).toJson(this); }

}
