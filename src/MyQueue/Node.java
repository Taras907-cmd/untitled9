package MyQueue;

public class Node<T> {
    private Node<T> nextNode;
    private Node<T> prevNode;
    private T value;


    public Node(Node<T> netNode, Node<T> prevNode, T value) {
        this.nextNode = netNode;
        this.prevNode = prevNode;
        this.value = value;
    }

    public Node(T value) {
        this.value = value;
    }


    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNexTNode(Node<T> nexTNode) {
        this.nextNode = nexTNode;
    }

    public Node<T> getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node<T> prevNode) {
        this.prevNode = prevNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" +
                value
                ;
    }
}
