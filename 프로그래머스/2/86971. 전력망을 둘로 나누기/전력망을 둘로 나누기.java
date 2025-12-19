import java.util.*;

class Solution {
    static boolean[] visited;
    static List<Edge>[] edges;
    static class Edge {
        int index;
        int to;
        Edge(int index, int to) {
            this.index = index;
            this.to = to;
        }
    }
    public int solution(int n, int[][] wires) {
        edges = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            edges[wires[i][0]].add(new Edge(i, wires[i][1]));
            edges[wires[i][1]].add(new Edge(i, wires[i][0]));
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            visited = new boolean[n + 1];
            int section1 = 0;
            int section2 = 0;
            for (int j = 1; j <= n; j++) {
                if (!visited[j]){
                    if (section1 == 0){
                        section1 = bfs(i, j);
                    } else {
                        section2 = bfs(i, j);
                    }
                } 
            }
            answer = Math.min(answer, Math.abs(section1 - section2));
        }
        
        return answer;
    }
    
    static int bfs(int skipEdge, int curr) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(curr);
        visited[curr] = true;
        
        while(!queue.isEmpty()) {
            count++;
            int next = queue.poll();
            for (Edge e : edges[next]) {
                if (e.index == skipEdge || visited[e.to]) {
                    continue;
                }
                
                queue.add(e.to);
                visited[e.to] = true;
            }
        }
        return count;
    }
}