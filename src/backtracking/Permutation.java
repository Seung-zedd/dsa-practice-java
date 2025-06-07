package src.backtracking;

import java.util.*;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, ans, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }

    private static void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> curr, boolean[] visited) {
        // base condition
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // 후보군 탐색
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                curr.add(nums[i]);

                backtrack(nums, ans, curr, visited);

                visited[i] = false;
                curr.removeLast();

            }
        }
    }

}
