import java.util.*;
class Solution {
    static int[] parent;
    static int[] ranking;
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        ranking = new int[n];
        Arrays.setAll(parent, i -> i);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Arrays.stream(costs).forEach(cost -> pq.add(new Edge(cost[0], cost[1], cost[2])));
        
        int answer = 0;
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if(union(e)) {
                answer += e.weight;
            }
        }
        
        return answer;
    }
    
    int find(int self) {
        if (parent[self] == self) {
            return self;
        }
        
        return find(parent[self]);
    }
    
    boolean union(Edge e) {
        int e1 = find(e.from);
        int e2 = find(e.to);
        if (e1 != e2) {
            if (ranking[e1]++ >= ranking[e2]) {
                parent[e2] = e1;
            } else {
                ranking[e2]++;
                parent[e1] = e2;
            }
            return true;
        }
        return false;
    }
    
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;
        public int compareTo (Edge e1) {
            return Integer.compare(weight, e1.weight);
        }
        
        Edge (int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}