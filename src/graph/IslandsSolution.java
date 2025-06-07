package src.graph;

/*
<문제 해석>
m x n 2차원 binary grid가 주어졌을 때, 섬들의 수를 리턴하라.(grid의 '1'은 land를, '0'은 물을 의미한다.)
- 섬들은 물로 둘러쌓여 있고, 연결된 인접의 섬들이 수평적으로 또는 수직적으로 형성되어 있다.
- 당신은 grid의 모든 4개의 간선들이 물로 둘러쌓여있다고 가정해도 된다.

- 제약 조건
m == grid.length (row)
n == grid[i].length (col)
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

<코드 설계>
1. 이중 for문으로 완전 탐색
2. 현재 방문하지 않았고 grid의 성분이 '1'이면 => bfs 탐색 시작
3. 인접 리스트가 아닌 암시적 그래프라서 dr, dc 세팅
4. 사전 세팅 -> for문 안에 dr, dc 순회하면서
5. grid 범위 안에 있고 && 현재 방문하지 않았으며 nextR, nextC 좌표가 '1'이면 => 방문 true && 큐에 추가
6. while문 빠져나가면 island++
7. 완전 탐색 끝나면 island 리턴


 */

public class IslandsSolution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int island = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    island += dfs(grid, visited, i, j, m, n);
                }
            }
        }
        return island;
    }

    private int dfs(char[][] grid, boolean[][] visited, int startR, int startC, int m, int n) {
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        visited[startR][startC] = true;

        for (int k = 0; k < 4; k++) {
            int nextR = startR + dr[k];
            int nextC = startC + dc[k];

            if ((0 <= nextR) && (nextR < m) && (0 <= nextC) && (nextC < n) && grid[nextR][nextC] == '1' && !visited[nextR][nextC]) {
                dfs(grid, visited, nextR, nextC, m, n);
            }
        }
        return 1;
    }


}
