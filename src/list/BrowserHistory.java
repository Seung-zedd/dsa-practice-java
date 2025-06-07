package src.list;

public class BrowserHistory {
    private String homepage;
    private Node cur; // 포인터를 이동해서 url을 리턴하기 위함

    static class Node {
        String url;
        Node next;
        Node prev;

        public Node(String url) {
            this.url = url;
            this.next = null;
            this.prev = null;
        }
    }

    public BrowserHistory(String homepage) {
        cur = new Node(homepage);
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        cur.next = newNode; // 생성된 노드와 연결
        newNode.prev = cur;
        cur = cur.next; // cur를 업데이트
    }

    public String back(int steps) {
        while (cur.prev != null && steps != 0) {
            cur = cur.prev;
            steps -= 1;
        }
        return cur.url;
    }


    public String forward(int steps) {
        while (cur.next != null && steps != 0) {
            cur = cur.next;
            steps -= 1;
        }
        return cur.url;
    }
}
