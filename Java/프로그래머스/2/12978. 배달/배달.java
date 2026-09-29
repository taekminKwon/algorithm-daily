import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] distance = new int[N + 1];
        List<Node>[] graph = new List[N + 1];
        Arrays.fill(distance, 100000000);
        distance[1] = 0;
        
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] r : road) {
            graph[r[0]].add(new Node(r[1], r[2]));
            graph[r[1]].add(new Node(r[0], r[2]));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Node n : graph[1]) {
            pq.add(n);
        }
        
        while (!pq.isEmpty()) {
            Node next = pq.poll();
            
            if (next.weight > distance[next.to]) {
                continue;
            }

            distance[next.to] = next.weight;
            
            for (Node n : graph[next.to]) {
                int newDistance = next.weight + n.weight;
                if (newDistance < distance[n.to]) {
                    distance[n.to] = newDistance;
                    pq.add(new Node(n.to, newDistance));
                }
            }
        }
        
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
    
    class Node implements Comparable<Node> {
        int to;
        int weight;
        
        public Node (int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        
        public int compareTo (Node node) {
            return Integer.compare(weight, node.weight);
        }
    }
}