package MyHashMap;

public class MyHashMap<K, V> {
    private Entry<K, V>[] buckets;
    int size = 0;

    public MyHashMap() {
        this.buckets = new Entry[10];
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;

        Entry<K, V> kvEntry = new Entry<K, V>();
        kvEntry.setKey(key);
        kvEntry.setValue(value);
        if (buckets[bucketNumber] == null) {
            buckets[bucketNumber] = kvEntry;
        } else {
            Entry<K, V> currentEntry = buckets[bucketNumber];
            while (currentEntry.getNextEntry() != null) {
                currentEntry = currentEntry.getNextEntry();
            }
        }
        size++;
    }

    public V get(K key) {
        int hash = key.hashCode();
        int buketNumber = hash % buckets.length;

        Entry<K, V> currentEntry = buckets[buketNumber];
        while (currentEntry.getNextEntry() != null) {
            V v = chekEquals(currentEntry, key);
            if (v != null) {
                return v;
            }
            currentEntry = currentEntry.getNextEntry();
        }
        return chekEquals(currentEntry, key);
    }

    public void remove(K key) {
        int hash = Math.abs(key.hashCode());
        int bucketNumber = hash % buckets.length;

        Entry<K, V> current = buckets[bucketNumber];
        Entry<K, V> prev = null;

        while (current != null) {
            if (current.getKey().equals(key)) {
                if (prev == null) {
                    buckets[bucketNumber] = current.getNextEntry();
                } else {
                    prev.setNextEntry(current.getNextEntry());
                }
                size--;
                return;
            }
            prev = current;
            current = current.getNextEntry();
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        this.buckets = new Entry[10];
        size = 0;
    }

    private V chekEquals(Entry<K, V> e, K key) {
        if (e.getKey().equals(key)) {
            return e.getValue();
        }
        return null;
    }

}
