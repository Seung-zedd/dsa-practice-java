package src;

import java.util.*;

class TestNode {
    int value;
    TestNode left;
    TestNode right;

    public TestNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class TestSolution {
    public List<Integer> levelOrder(TestNode root) {
        // base condition
        if (root == null) {
            return new ArrayList<>();
        }
        // 사전 세팅
        List<Integer> visited = new ArrayList<>();
        Queue<TestNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TestNode curNode = q.poll();
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

}
