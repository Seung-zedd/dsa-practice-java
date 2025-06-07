package src.recursion.tree;

/*
<문제 해석>
이진 트리가 주어지면 트리에서 주어진 두 노드의 가장 낮은 공통 조상 (LCA)을 찾으십시오.
LCA: "가장 낮은 공통 조상은 두 노드 P와 Q 사이에서 P와 Q를 자손으로서 T에서 가장 낮은 노드로 정의됩니다 ( 노드 자체가 후손이 될 수 있습니다)."

- 제약 조건 -
1. 노드의 수: [2, 10^5]
=> bfs 또는 dfs의 노드 탐색 시간복잡도는 O(N)이므로 가능
=> 노드의 최소 개수가 2라는 것은, 부모 노드와 자식 노드만 존재할 수도 있다는 의미

2. -10^9 <= Node.val <= 10^9
=> 노드의 val은 int 타입

3. 모든 노드의 val은 unique하고, p와 q 노드는 다르다.
4. p와 q 노드는 트리 구조에서 존재한다.
=> p와 q가 같은 노드일 수 없고, p 또는 q 노드만 존재할 수도 없다는 의미다.


<코드 설계>
1. 재귀적으로 p와 q 노드를 먼저 찾는다.
-> 데이터 크기가 추상화됬으므로, 완전탐색

2. p와 q의 공통 조상 노드를 찾는다.
    1) p와 q가 다른 subtree에 존재: root 노드가 LCA
    2) p와 q가 같은 subtree에 존재: depth가 낮은 노드가 LCA

 */

public class LcaSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base condition
        if (root == null) {
            return null;
        }

        // preorder traversal
        if (root == p) {
            return p;
        }
        if (root == q) {
            return q;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // subtree가 다른 경우
        if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }

    }
}


