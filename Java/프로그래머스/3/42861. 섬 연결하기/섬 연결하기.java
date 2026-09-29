import java.util.*;

class Solution {
    static int[] parent;
    static int[] ranking;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        ranking = new int[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int[] cost : costs) {
            pq.add(new Edge(cost[0], cost[1], cost[2]));
        }
        
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if (union(e)) {
                answer += e.weight;
            }
        }
        
        return answer;
    }
    
    public boolean union(Edge e) {
        int a = find(e.from);
        int b = find(e.to);
        
        if (a == b) {
            return false;
        }
        
        if (ranking[a] > ranking[b]) {
            parent[b] = a;
        } else if (ranking[b] > ranking[a]) {
            parent[a] = b;
        } else {
            ranking[a]++;
            parent[b] = a;
        }
        
        return true;
    }
    
    public int find(int i) {
        if (i != parent[i]) {
            parent[i] = find(parent[i]);
        }
        
        return parent[i];
    }
    
    public class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;
        
        Edge (int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        
        public int compareTo(Edge e) {
            return Integer.compare(weight, e.weight);
        }
    }
}