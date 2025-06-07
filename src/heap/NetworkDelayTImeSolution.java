package src.heap;

import java.util.*;

/*
<문제 해석>
1~N번 까지의 N개의 노드가 주어졌다.
-> dist를 n+1 크기로 초기화해야겠구나
유향 그래프를 가진 times[i] = (u, v, w): u는 source 노드, v는 target 노드, w(간선, 비용)는 source부터 target까지 가는데 걸리는 신호의 시간

우리는 주어진 k 노드로부터 신호를 보낼 것이다. 이때, 모든 N개의 노드가 신호를 받는데 걸리는 최소 시간을 리턴하라.(만약 모든 N개의 노드가 신호를 받지 못하면 -1을 리턴하라.)

<코드 설계>
주어진 k 노드: 시작 정점

dist[end] => for문으로 돌려서 하나라도 Integer.MAX_VALUE가 있으면 -1을 리턴





 */

public class NetworkDelayTImeSolution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 사전 세팅
        int[] dist = new int[n + 1];
        // 비용을 우선순위
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curCost = cur[1];

            // BFS 큐보다 현재 비용이 작으면 아래의 과정을 스킵
            if (curCost > dist[curNode]) continue;

            // 인접 노드 탐색
            for (int i = 0; i < times.length; i++) {
                if (curNode == times[i][0]) {
                    // 일단 비용을 업데이트
                    int nextNode = times[i][1];
                    int nextCost = curCost + times[i][2];

                    // BFS 탐색 비용이 현재 비용보다 적으면 dist 방문
                    if (nextCost < dist[nextNode]) {
                        dist[nextNode] = nextCost;
                        pq.offer(new int[]{nextNode, nextCost});
                    }
                }
            }
        }

        // 모든 N개의 노드까지 걸린 최소 시간을 리턴하기 위해 dist의 최댓값 리턴
        int max_val = 0;
        for (int i = 1; i < dist.length; i++) {
            max_val = Math.max(max_val, dist[i]);
        }

        return max_val == Integer.MAX_VALUE ? -1 : max_val;


    }

}
