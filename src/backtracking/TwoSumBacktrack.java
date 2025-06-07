package src.backtracking;

import java.util.*;

public class TwoSumBacktrack {
    public int[] twoSum(int[] nums, int target) {
        boolean found = false;
        int[] result = new int[2];
        backtrack(nums, result, new ArrayList<>(), 0, target, found);
        return result;

    }

    private static void backtrack(int[] nums, int[] result, List<Integer> curr, int start, int target, boolean found) {
        // 조기 종료: 이미 답을 찾은 경우
        if (found) return;

        // base condition
        if (curr.size() == 2) {
            if (nums[curr.get(0)] + nums[curr.get(1)] == target) {
                result[0] = curr.get(0);
                result[1] = curr.get(1);
                found = true;
            }

            return;
        }

        // iteration
        for (int i = start; i < nums.length; i++) {
            curr.add(i); // 인덱스를 저장
            backtrack(nums, result, curr, i + 1, target, found);
            curr.removeLast();
        }
    }
}
