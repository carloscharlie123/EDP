public class PythonDict {
    private Object[] keys;
    private Object[] values;
    private int size;

    public PythonDict(int capacity) {
        keys = new Object[capacity];
        values = new Object[capacity];
        size = 0;
    }

    public Object get(Object key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    public void put(Object key, Object value) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    public int size() {
        return size;
    }

    public boolean containsKey(Object key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return true;
            }
        }
        return false;
    }
}
