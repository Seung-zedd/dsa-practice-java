package src.recursion.tree;

import java.util.*;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class OrderTraversal {
    public List<Integer> levelOrder(Node root) {
        // base condition
        if (root == null) {
            return new ArrayList<>(); // null 대신 빈 리스트를 반환해야 안전
        }

        // 사전 세팅
        List<Integer> visited = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        // Enqueue Root
        q.offer(root);

        // 인접 노드 탐색
        while (!q.isEmpty()) {
            // Dequeue a front node in the queue
            Node curNode = q.poll();
            visited.add(curNode.value);

            if (curNode.left != null) {
                q.offer(curNode.left);
            }
            if (curNode.right != null) {
                q.offer(curNode.right);
            }
        }
        return visited;

    }



    public List<Integer> inOrder(Node root) {
        // base condition
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> visited = new ArrayList<>();
        inOrder(root.left);
        visited.add(root.value);
        inOrder(root.right);
        return visited;

    }

    public List<Integer> postOrder(Node root) {
        // base condition
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> visited = new ArrayList<>();
        postOrder(root.left);
        postOrder(root.right);
        visited.add(root.value);
        return visited;

    }

}
