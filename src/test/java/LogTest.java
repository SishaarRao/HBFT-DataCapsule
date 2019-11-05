import DataCapsule.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogTest {
    @Test
    public void testCreate() {
        Log<String> test = new Log<String>();
        Assert.assertNotNull(test);
    }

    @Test
    public void testAppend() {
        Log<String> test = new Log<String>();
        String toAppend = "test";
        Assert.assertEquals(test.append(toAppend), toAppend);
        Assert.assertEquals(test.append(toAppend), toAppend);
        Assert.assertEquals(test.size(), 2);
    }
    @Test
    public void testToString() {
        Log<String> test = new Log<String>();
        String toAppend = "test";
        test.append(toAppend);
        Assert.assertTrue(test.toString().contains(toAppend));
    }
}
