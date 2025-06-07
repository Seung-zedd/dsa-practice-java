package src.dp;

/*
<문제 해석>
당신은 int 타입의 cost 배열이 주어졌는데, cost[i]는 i번째 계단을 밟았을 때 지불해야 하는 비용이다. 당신이 비용을 지불하면, 당신은 1 스텝 또는 2 스텝의 계단을 오를 수 있다.
당신은 인덱스 0부터 시작하거나 인덱스 1부터 시작할 수도 있다.

이때, top에 도달하기 위한 최소 비용을 리턴하라.

- 제약 조건 -
1. 2 <= cost.length <= 1000
2. 0 <= cost[i] <= 999


 */

import java.util.HashMap;

public class MinCostClimbingStairsSolution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        HashMap<Integer, Integer> memo = new HashMap<>(); // {index: cost}
        return dp(n, cost, memo);
    }

    private static int dp(int n, int[] cost, HashMap<Integer, Integer> memo) {

        // base condition
        if (n <= 1) {
            return 0;
        }

        if (!memo.containsKey(n)) {
            memo.put(n, Math.min(dp(n - 1, cost, memo) + cost[n - 1], dp(n - 2, cost, memo) + cost[n - 2]));
        }

        return memo.get(n);
    }
}
