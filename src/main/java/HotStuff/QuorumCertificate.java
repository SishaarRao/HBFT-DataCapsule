package HotStuff;

public class QuorumCertificate {
    ReplicaID id;
    ViewNumber viewNumber;

    public QuorumCertificate(ReplicaID _id, ViewNumber _viewNumber) {
        id = _id;
        viewNumber = _viewNumber;
    }

    @Override
    public String toString() {
        return String.format("QC: <Replica: %s, View: %s>", id.toString(), viewNumber.toString());
    }
}
