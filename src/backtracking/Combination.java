package src.backtracking;

import java.util.*;

public class Combination {
    public List<List<Integer>> combine(int[] nums, int r) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), ans, new boolean[nums.length], 0, 3);
        return ans;
    }

    private static void backtrack(int[] nums, List<Integer> curr, List<List<Integer>> ans, boolean[] visited, int start, int r) {
        // base condition
        if (curr.size() == r) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // 후보군 탐색
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                curr.add(nums[i]);
                backtrack(nums, curr, ans, visited, i + 1, r);
                visited[i] = false;
                curr.removeLast();

            }
        }
    }


}
