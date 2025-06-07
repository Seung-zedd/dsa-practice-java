package src.graph;

import java.util.*;

/*
<문제 해석>
n x n 이진 행렬 grid가 주어졌을 때, 행렬에서 가장 짧은 clear path를 리턴하라.(단, clear path가 없으면 -1을 리턴하라)

clear path: (0,0) -> (n-1, n-1)로 가는 path를 말함:
1. path의 모든 방문한 셀들은 0이다.
2. path의 인접한 셀들은 8-directionally로 연결되어 있다.(그들은 모두 다르고, 그들은 간선 또는 구석을 공유한다.)
3. clear path의 길이는 방문한 셀들의 수이다.

- 제약 조건 -
1. m = row, n = col
2. 1 <= m, n <= 100
=> m*n = 10000 < 10^8 이므로 brute-force 가능
3. grid[i][j]는 0 또는 1이다.

<코드 설계>
1. (0,0) 또는 (n-1, n-1)이 1이면 clear path가 아니므로 -1을 리턴
2. dfs로 하면 0이 표시된 셀들은 무조건 방문하기 때문에 shorest path가 나올 수 x => bfs 알고리즘 선택
3. bfs 함수 템플릿 그대로 사용하는데, Tree에서 했던 커스텀 클래스를 사용해서 셀마다 방문한 횟수를 업데이트한다.



 */

public class ShortestPathSolution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        final int[] dr = {-1, 1, 0, 0, -1, 1, 1, -1};
        final int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

        // 시점이나 종점이 막혀있으면 no clear path
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }

        // 시점이 안막혀 있으면 bfs 탐색 시작
        // 사전 세팅
        if (grid[0][0] == 0) {
            visited[0][0] = true;
            Queue<Point> q = new LinkedList<>();
            q.offer(new Point(0, 0, 1));

            while (!q.isEmpty()) {
                Point cur = q.poll();
                int startR = cur.r;
                int startC = cur.c;
                int curCount = cur.count;

                // 현재 좌표가 종점이면 그대로 리턴
                if ((startR == m - 1) && (startC == n - 1)) {
                    return curCount;
                }
                for (int i = 0; i < 8; i++) {
                    int nextR = startR + dr[i];
                    int nextC = startC + dc[i];

                    // 범위 및 방문 체크
                    if ((nextR >= 0 && (nextR < m) && (nextC >= 0 && nextC < n) && grid[nextR][nextC] == 0 && !visited[nextR][nextC])) {
                        visited[nextR][nextC] = true;
                        q.offer(new Point(nextR, nextC, curCount + 1));
                    }
                }
            }

        }
        return -1;
    }

    private static class Point {
        int r;
        int c;
        int count;

        public Point(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
}
