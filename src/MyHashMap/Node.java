package MyHashMap;

public class Node<K, V> {
    private K key;
    private V value;
    private Node<K, V> nextEntry;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<K, V> getNextEntry() {
        return nextEntry;
    }

    public void setNextEntry(Node<K, V> nextEntry) {
        this.nextEntry = nextEntry;
    }
}
