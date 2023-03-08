import org.junit.Test;
import static org.junit.Assert.*;

public class PythonDictTest {
    @Test
    public void testPutAndGet() {
        PythonDict dict = new PythonDict(10);
        dict.put("key1", "value1");
        dict.put("key2", "value2");
        dict.put("key3", "value3");
        assertEquals("value1", dict.get("key1"));
        assertEquals("value2", dict.get("key2"));
        assertEquals("value3", dict.get("key3"));
    }

    @Test
    public void testContainsKey() {
        PythonDict dict = new PythonDict(10);
        dict.put("key1", "value1");
        dict.put("key2", "value2");
        assertTrue(dict.containsKey("key1"));
        assertTrue(dict.containsKey("key2"));
        assertFalse(dict.containsKey("key3"));
    }

    @Test
    public void testSize() {
        PythonDict dict = new PythonDict(10
