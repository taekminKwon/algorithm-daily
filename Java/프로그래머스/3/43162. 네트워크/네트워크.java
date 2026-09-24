import java.util.*;

class Solution {
    static boolean[] isConnected;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        isConnected = new boolean[computers.length];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer>[] link = new List[computers.length];
        for (int i = 0; i < link.length; i++) {
            link[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < computers.length; i++) {
            for (int j = i + 1; j < computers[i].length; j++) {
                if (computers[i][j] == 1) {
                    link[i].add(j);
                    link[j].add(i);
                }
            }
        }
        
        for (int i = 0; i < computers.length; i++) {
            if (!isConnected[i]) {
                answer++;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int next = queue.poll();
                    for (int j = 0; j < link[next].size(); j++) {
                        int neighbor = link[next].get(j);
                        if (isConnected[neighbor]){
                            continue;
                        }
                    
                        isConnected[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
        }
        
        return answer;
    }
}