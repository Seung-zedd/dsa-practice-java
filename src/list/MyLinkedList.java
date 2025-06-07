package src.list;

class Node {
    int value;
    DoublyNode next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class MyLinkedList {
    DoublyNode head;
    DoublyNode tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void append(int value) {
        DoublyNode newNode = new DoublyNode(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next; // tail은 항상 마지막 노드를 가리킴(이게 훨씬 ptr가 업데이트된다는 것에 직관적임)
        }
    }

    public int get(int idx) {
        DoublyNode ptr = head;
        for (int i = 0; i < idx; i++) {
            ptr = ptr.next;
        }
        return ptr.value;
    }

    public void insert(int idx, int value) {
        DoublyNode newNode = new DoublyNode(value);
        DoublyNode ptr = head;

        if (idx == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            for (int i = 0; i < idx - 1; i++) {
                ptr = ptr.next;
            }
            newNode.next = ptr.next;
            ptr.next = newNode;
        }
    }

    public void remove(int idx) {
        DoublyNode ptr = head;

        if (idx == 0) {
            head = head.next; // head를 이동
        } else {
            for (int i = 0; i < idx - 1; i++) {
                ptr = ptr.next;
            }
            ptr.next = ptr.next.next; // 삭제하려고 하는 노드의 next값을 바로 직전 노드가 가리키게 함
        }
    }
}


