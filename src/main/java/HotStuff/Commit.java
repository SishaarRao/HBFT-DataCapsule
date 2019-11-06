package HotStuff;

import DataCapsule.*;
import com.google.gson.Gson;

/**
 * Represents a commit cast by the leader in the given cycle on a given proposal of changes
 *
 * Currently there is no cryptographically guaranteed approval or rejection (e.g. assume no malicious intent on commit)
 *
 * TODO: Use hash on DataCapsule?
 */
public class Commit {
    ReplicaID id;
    private final DataCapsule data;
    boolean decision = false;

    public Commit(ReplicaID _id, DataCapsule _data) {
        id = _id;
        data = _data;
    }

    public Commit parse(String json) { return (new Gson()).fromJson(json, Commit.class); }

    @Override
    public String toString() { return (new Gson()).toJson(this); }

}
