import DataCapsule.*;
import HotStuff.Proposal;
import HotStuff.ReplicaID;

/**
 * Playground for testing out functionality, seeing how things work.
 */
public class Playground {
    public static void main(String[] args) {
        DataCapsule<String> testing = new DataCapsule<String>(new ReplicaID(1));
        testing.append("This is the first test string");
        testing.append("This is the second test string");

        Proposal proposal = new Proposal(1, testing);
        System.out.println(proposal.toString());
    }
}
