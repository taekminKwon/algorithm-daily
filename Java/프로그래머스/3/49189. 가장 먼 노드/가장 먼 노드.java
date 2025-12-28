import java.util.*;

class Solution {
    static int[] distances;
    static List<Integer>[] edges;
    static final int INF = Integer.MAX_VALUE;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int max = 0;
        distances = new int[n + 1];
        edges = new List[n + 1];
        
        Arrays.fill(distances, INF);
        distances[1] = 0;
        
        for (int i = 0; i < n + 1; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edge.length; i++) {
            edges[edge[i][0]].add(edge[i][1]);
            edges[edge[i][1]].add(edge[i][0]);
        }
        
        dijkstra();
        
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] != INF)
                max = Math.max(distances[i], max);
        }
        
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] == max) {
                answer++;
            }
        }
        return answer;
    }
    
    public void dijkstra() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()) {
            int position = queue.poll();
            for (Integer i : edges[position]) {
                if (distances[position] + 1 < distances[i]) {
                    distances[i] = distances[position] + 1;
                    queue.add(i);
                }
            }
        }
    }
}