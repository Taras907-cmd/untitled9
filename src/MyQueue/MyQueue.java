package MyQueue;


public class MyQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNexTNode(newNode);
            tail = newNode;
        }
        size++;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public T peek() {
        return head.getValue();
    }

    public T poll() {
        T value = head.getValue();
        head = head.getNextNode();
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            sb.append(current.getValue());
            sb.append(" ");
            current = current.getNextNode();
        }
        return sb.toString();
    }

}
