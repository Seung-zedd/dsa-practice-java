package src.list;

class DoublyNode {
    int value;
    DoublyNode next;
    DoublyNode prev;

    public DoublyNode(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

public class MyDoublyLinkedList {
    DoublyNode head = null;
    DoublyNode tail = null;

    public void append(int value) {
        DoublyNode newNode = new DoublyNode(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
        }
    }
}
