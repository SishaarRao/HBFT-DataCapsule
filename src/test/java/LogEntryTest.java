import DataCapsule.LogEntry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogEntryTest {
    @Test
    public void testCreateAndGet() {
        LogEntry<String> entry = new LogEntry<String>("test");
        LogEntry<Integer> entry2 = new LogEntry<Integer>(2);

        Assert.assertEquals((String) entry.get(), "test");
        Assert.assertEquals((int) entry2.get(), 2);
    }
}
