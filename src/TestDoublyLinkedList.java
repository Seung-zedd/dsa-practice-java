package src;

class Node {
    int value;
    Node next;
    Node prev;

    public Node(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

public class TestDoublyLinkedList {
    Node head = null;
    Node tail = null;

    public void append(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
        }
    }

    public int get(int idx) {
        Node ptr = head;

        for (int i = 0; i < idx; i++) {
            ptr = ptr.next;
        }
        return ptr.value;
    }

    public void insert(int idx, int value) {
        Node newNode = new Node(value);

        if (idx == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node ptr = head;
            for (int i = 0; i < idx - 1; i++) {
                ptr = ptr.next;
            }
            newNode.next = ptr.next;
            ptr.next = newNode;
        }
    }

    public void remove(int idx) {
        if (idx == 0) {
            head = head.next; // head 이동
        } else {
            Node ptr = head;
            for (int i = 0; i < idx - 1; i++) {
                ptr = ptr.next;
            }
            ptr.next = ptr.next.next; // 다음 노드로 연결
        }
    }


}
