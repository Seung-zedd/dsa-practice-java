package src.backtracking;

import java.util.*;

public class Subset {
    public List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // 0~n까지의 모든 조합을 구함
        for (int r = 0; r < nums.length + 1; r++) {
            backtrack(nums, new ArrayList<>(), ans, new boolean[nums.length], 0, r);
        }

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

