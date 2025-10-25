package MyLinkedList;

public class MyLinkedList<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size = 0;

    public void add(T val) {
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
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> currentNode;
        if (index < size / 2) {
            currentNode = firstNode;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNextNode();
            }
        } else {
            currentNode = lastNode;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.getPrevNode();
            }
        }

        return currentNode.getValue();
    }


    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> toDelete;


        if (index < size / 2) {
            toDelete = firstNode;
            for (int i = 0; i < index; i++) {
                toDelete = toDelete.getNextNode();
            }
        } else {
            toDelete = lastNode;
            for (int i = size - 1; i > index; i--) {
                toDelete = toDelete.getPrevNode();
            }
        }

        Node<T> prev = toDelete.getPrevNode();
        Node<T> next = toDelete.getNextNode();

        if (prev != null) prev.setNextNode(next);
        else firstNode = next;

        if (next != null) next.setPrevNode(prev);
        else lastNode = prev;

        size--;
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
