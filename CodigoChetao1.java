public class Dictionary {
    private final int DEFAULT_CAPACITY = 16;
    private final float LOAD_FACTOR = 0.75f;

    private int capacity;
    private int size;
    private Entry[] entries;

    public Dictionary() {
        this.capacity = DEFAULT_CAPACITY;
        this.entries = new Entry[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public Dictionary(int capacity) {
        this.capacity = capacity;
        this.entries = new Entry[capacity];
        this.size = 0;
    }

    private int hash(Object key) {
        int hash = key.hashCode() % capacity;
        return hash < 0 ? -hash : hash;
    }

    private void rehash() {
        capacity = capacity * 2;
        Entry[] newEntries = new Entry[capacity];

        for (int i = 0; i < entries.length; i++) {
            Entry entry = entries[i];
            while (entry != null) {
                Entry next = entry.next;
                int index = hash(entry.key);
                entry.next = newEntries[index];
                newEntries[index] = entry;
                entry = next;
            }
        }
        entries = newEntries;
    }

    public void put(Object key, Object value) {
        int index = hash(key);

        Entry entry = entries[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }

        Entry newEntry = new Entry(key, value);
        newEntry.next = entries[index];
        entries[index] = newEntry;
        size++;

        if (size > capacity * LOAD_FACTOR) {
            rehash();
        }
    }

    public Object get(Object key) {
        int index = hash(key);
        Entry entry = entries[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public boolean containsKey(Object key) {
        int index = hash(key);
        Entry entry = entries[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return true;
            }
            entry = entry.next;
        }
        return false;
    }

    public boolean containsValue(Object value) {
        for (int i = 0; i < entries.length; i++) {
            Entry entry = entries[i];
            while (entry != null) {
                if (entry.value.equals(value)) {
                    return true;
                }
                entry = entry.next;
            }
        }
        return false;
    }
}
