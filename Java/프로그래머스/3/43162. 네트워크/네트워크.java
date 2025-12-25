import java.util.*;

class Solution {
    static boolean[] visited;
    static List<Integer>[] list;
    public int solution(int n, int[][] computers) {
        list = new List[n];
        visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
            int[] computer = computers[i];
            
            for(int j = 0; j < n; j++) {
                if (i != j && computer[j] == 1) {
                    list[i].add(j);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (Integer n : list[curr]) {
                if (visited[n]) {
                    continue;
                }
                
                visited[n] = true;
                queue.add(n);
            }
        }
    }
}