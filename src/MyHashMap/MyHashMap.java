package MyHashMap;

public class MyHashMap<K, V> {
    private Node<K, V>[] buckets;
    private int size = 0;

    public MyHashMap() {
        this.buckets = new Node[16];
    }

    public void put(K key, V value) {
        int bucketNumber = getBucketIndex(key);


        Node<K, V> kvEntry = new Node<K, V>();
        kvEntry.setKey(key);
        kvEntry.setValue(value);
        if (buckets[bucketNumber] == null) {
            buckets[bucketNumber] = kvEntry;
        } else {
            Node<K, V> currentEntry = buckets[bucketNumber];
            while (currentEntry.getNextEntry() != null) {
                currentEntry = currentEntry.getNextEntry();
            }
        }
        size++;
    }

    public V get(K key) {
        int bucketNumber = getBucketIndex(key);


        Node<K, V> currentEntry = buckets[bucketNumber];
        if (currentEntry == null) {
            return null;
        }
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
        int bucketNumber = getBucketIndex(key);


        Node<K, V> current = buckets[bucketNumber];
        Node<K, V> prev = null;

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
        this.buckets = new Node[10];
        size = 0;
    }

    private V chekEquals(Node<K, V> e, K key) {
        if (e.getKey().equals(key)) {
            return e.getValue();
        }
        return null;
    }

    private int getBucketIndex(K key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % buckets.length);
    }


}
