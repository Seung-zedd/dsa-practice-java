package src.dp;

/*
<문제 해석>
m x n grid에 로봇이 있다. 로봇은 처음에 grid[0][0]에 위치해 있다. 로봇은 grid[m-1][n-1]로 이동하려고 한다. 로봇은 한번 움직일 때 **아래 또는 오른쪽**으로 밖에 이동하지 못한다.

이때 int형 m, n이 주어졌을 때, 로봇이 grid[m-1][n-1]로 도착할 수 있는 가능한 unique paths의 수를 리턴하라.
(단, 답은 2 * 10^9 이하의 시간복잡도를 가져야 한다.)

- 제약 조건 -
1 <= m, n <= 10^2 => 만약 완전탐색할 경우, O(N^2) = 10^4이므로 가능! But recursive function으로 구현할 경우 -> O(2^N) = 2^100은 불가!

<문제 설계>
grid 완전 탐색 또는 dp를 적용하면 10^4 또는 10^2로 가능!!

1. 완전탐색으로 접근(using permutation), lasting O(N^2)

 */

public class UniquePathSolution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 모서리를 1로 채운다(row)
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // col
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // 점화식
        for (int i = 1; i < m; i++) {
            for (int j = 1; i < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1]; // 종점 리턴
    }


}