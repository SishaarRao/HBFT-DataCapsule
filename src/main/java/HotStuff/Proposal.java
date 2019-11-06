package HotStuff;

import DataCapsule.*;
import com.google.gson.Gson;

/**
 * Represents a proposal of changes associated to a replica
 */
public class Proposal {
    ReplicaID id;
    private final DataCapsule data;

    public Proposal(ReplicaID _id, DataCapsule _data) {
        id = _id;
        data = _data;
    }

    public Proposal parse(String json) { return (new Gson()).fromJson(json, Proposal.class); }

    @Override
    public String toString() { return (new Gson()).toJson(this); }

}
