package MyStack;

import MyQueue.Node;


public class MyStack<T> {
    private Node<T> head;
    private int size = 0;

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNexTNode(head);
        head = newNode;
        size++;
    }

    public T pop() {
        T value = head.getValue();
        head = head.getNextNode();
        size--;
        return value;
    }

    public void remove(int index) {
        if (index == 0) {
            head = head.getNextNode();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNextNode();
            }
            current.setNexTNode(current.getNextNode().getNextNode());
        }
        size--;
    }

    public T peek() {
        return head.getValue();
    }

    public int size() {

        return size;
    }

    public void clear() {
        head = null;
        size = 0;
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
