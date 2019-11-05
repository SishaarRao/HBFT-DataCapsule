import DataCapsule.DataCapsule;
import sun.reflect.annotation.ExceptionProxy;

/**
 * Playground for testing out functionality, seeing how things work.
 */
public class Playground {
    public static void main(String[] args) {
        DataCapsule<String> testing = new DataCapsule<String>(1);
        testing.append("This is the first test string");

        try {Thread.sleep(2000); } catch(Exception e) { return; }

        testing.append("This is the second test string");
        System.out.println(testing.toString());
    }
}
