package src.heap;

import java.util.*;

/*
// 가중치가 있는 bfs
1. 사전 세팅
2. while (!q.isEmpty()):





 */

public class Dijkstra {
    public int dijkstra(List<List<NodeCost>> graph, int start, int end) {
        // 사전 세팅
        int[] dist = new int[graph.size()];
        PriorityQueue<NodeCost> pq = new PriorityQueue<>((node1, node2) -> Integer.compare(node1.cost, node2.cost));
        Arrays.fill(dist, Integer.MAX_VALUE); // 무한대
        // 시작 정점 추가
        dist[start] = 0;
        pq.offer(new NodeCost(start, 0));

        while (!pq.isEmpty()) {
            NodeCost cur = pq.poll();
            int curNode = cur.node;
            int curCost = cur.cost;

            // BFS 비용이 현재 알려진 노드 비용보다 크면 아래의 과정 스킵
            if (curCost > dist[curNode]) continue;

            // 인접 노드 탐색
            for (NodeCost nextNode : graph.get(curNode)) {
                // 일단 비용 업데이트
                int nextCost = curCost + nextNode.cost;

                // 더 짧은 비용이 있으면
                if (nextCost < dist[nextNode.node]) {
                    dist[nextNode.node] = nextCost;
                    pq.offer(new NodeCost(nextNode.node, nextCost));
                }
            }
        }
        return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
    }

    private static class NodeCost {
        int node;
        int cost;

        public NodeCost(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }



}
