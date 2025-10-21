package MyLinkedList;

public class MyLinkedList<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size = 0;

    public void add(T val) {
        size++;
        if (firstNode == null) {
            firstNode = new Node<>(null, null, val);
        } else if (lastNode == null) {
            lastNode = new Node<T>(firstNode, null, val);
            firstNode.setNextNode(lastNode);
        } else {
            Node<T> nexLastNode = new Node<T>(lastNode, null, val);
            lastNode.setNextNode(nexLastNode);
            lastNode = nexLastNode;
        }
    }

    public T get(int index) {
        Node<T> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getValue();
    }

    public void remove(int index) {
        size--;
        if (index == 0) {
            firstNode = firstNode.getNextNode();
        }
        Node<T> prevNode = firstNode;
        for (int i = 0; i < index - 1; i++) {
            prevNode = prevNode.getNextNode();
        }
        Node<T> toDelete = prevNode.getNextNode();
        if (toDelete == null) {
            return;
        }
        prevNode.setNextNode(toDelete.getNextNode());
        if (toDelete == lastNode) {
            lastNode = prevNode;
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }
}
