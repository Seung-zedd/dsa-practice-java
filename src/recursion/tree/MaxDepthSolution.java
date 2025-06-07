package src.recursion.tree;


/*

<문제 해석>
 이진 트리의 root가 주어졌을 때, 그것의 최대 depth를 리턴하라.
 이진트리의 최대 깊이: root 노드로부터 가장 먼 leaf 노드까지의 거리를 말함
 - 제약 조건 -
 1. 노드의 수: [0, 10^4]
 => 어짜피 bfs, dfs의 시간복잡도는 O(N)이므로 OK
 2. 100 <= Node.val <= 100
 <코드 설계>
 ! ++curLevel과 curLevel + 1은 엄연히 다름, 전자는 levelorder를 할 때 sibling의 노드의 level에 영향을 받기 때문에 그대로 증가가 되는 반면, 후자는 root의 레벨에서 독립적으로 증가하기 때문이다.

 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


public class MaxDepthSolution {
    public int maxDepth(TreeNode root) {
        // base condition
        if (root == null) {
            return 0;
        }

        // postorder traversal
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;

        return Math.max(left, right);
    }



}
