package src.graph;

import java.util.*;

/*
<문제 해석>
0부터 n-1까지의 번호가 있는 n개의 방들이 있고, 모든 방들은 0번 방을 제외하고 모두 잠겨있다.
너의 목표는 모든 방들을 방문하는 것이다. 하지만, 당신은 방에 해당되는 열쇠 없이는 잠긴 방에 들어갈 수 없다.

방에 방문할 때, 당신은 그곳에서 구별되는 열쇠들을 찾을 수 있다. 각각의 열쇠들은 방을 열 수 있는 번호들이 적혀있고, 당신은 다른 방들을 열 수 있는 그것들을 모두 가져갈 수도 있다.

i번째 방에 방문하면 열쇠 세트를 얻을 수 있는 방들이 배열로 주어졌을 때, 모든 방들을 방문할 수 있으면 true를, 그렇지 않으면 false를 리턴하라.

- 제약 조건 -
1. n == rooms.length
2. 2 <= n <= 1000
3. 0 <= rooms[i].length <= 1000
=> 1000 * 1000 = 10^6 < 10^8이므로 brute-force 가능
4. 1 <= sum(rooms[i].length) <= 3000
=> 적어도 1번 이상의 열쇠는 있다는 의미
5. 0 <= rooms[i][j] < n
=> 0부터 n-1까지의 번호
6. rooms[i]의 모든 값들은 unique하다.(중복되는 value가 없다는 의미)

<코드 설계>
0번방을 제외하고 모두 잠겨있다 -> rooms[0][0]부터 방문하라는 의미
모든 방들을 방문 -> bfs 또는 dfs로 모든 정점을 방문
방들을 방문할 때 distinct keys들을 얻을 수 있음 -> 번호가 적혀있는 해당 정점에 방문할 수 있음

each room == Vertex, distinct keys == Edge

 */


public class KeysAndRoomsSolution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        // 사전 세팅
        visited[0] = true;
        List<Integer> keys = rooms.get(0);

        // 인접 리스트 순회
        for (Integer key : keys) {
            if (!visited[key]) {
                dfs(key, visited, rooms);
            }
        }

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;

    }

    private static void dfs(Integer key, boolean[] visited, List<List<Integer>> rooms) {
        visited[key] = true;
        List<Integer> keys = rooms.get(key);

        for (Integer k : keys) {
            if (!visited[k]) {
                dfs(k, visited, rooms);
            }
        }
    }


}
