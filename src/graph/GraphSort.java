package src.graph;

import java.util.*;

/*
maze = [
        [1, 1, 1, 1, 1],
        [0, 0, 0, 1, 1],
        [1, 1, 0, 1, 1],
        [1, 0, 0, 0, 0],
        [1, 1, 1, 1, 1],
        ]
 */

public class GraphSort {
    // declared global var for dfs method
    static LinkedHashSet<String> visited = new LinkedHashSet<>();
    public static void main(String[] args) {
        System.out.println(bfs()); // [A, B, C, E, D, F]
        System.out.println(dfs("A"));

    }

    public static Set<String> dfs(String curNode) {
        HashMap<String, List<String>> graph = createGraph();
        visited.add(curNode);

        for (String v : graph.get(curNode)) {
            if (!visited.contains(v)) {
                dfs(v);
            }
        }
        return visited;
    }

    public static Set<String> bfs() {
        HashMap<String, List<String>> graph = createGraph();
        String startNode = "A";
        // 사전 세팅
        LinkedHashSet<String> visited = new LinkedHashSet<>();
        Queue<String> q = new LinkedList<>();
        visited.add(startNode);
        q.offer(startNode);

        // bfs 탐색
        while (!q.isEmpty()) {
            String curNode = q.poll();

            for (String v : graph.get(curNode)) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    q.offer(v);
                }
            }

        }
        return visited;
    }


        private static HashMap<String, List<String>> createGraph() {
            HashMap<String, List<String>> graph = new HashMap<>();
            graph.put("A", List.of("B", "D", "E"));
            graph.put("B", List.of("A", "C", "D"));
            graph.put("C", List.of("B"));
            graph.put("D", List.of("A", "B"));
            graph.put("E", List.of("A"));

            return graph;
        }





}