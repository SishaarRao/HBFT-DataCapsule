package HotStuff;

import DataCapsule.DataCapsule;
import com.google.gson.Gson;

public class Proposal {
    int ReplicaID;
    DataCapsule data;

    public Proposal(int _uid, DataCapsule _data) {
        ReplicaID = _uid;
        data = _data;
    }



    public Proposal parse(String json) { return (new Gson()).fromJson(json, Proposal.class); }

    @Override
    public String toString() { return (new Gson()).toJson(this); }

}
