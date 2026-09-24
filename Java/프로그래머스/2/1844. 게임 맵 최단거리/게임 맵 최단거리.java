import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] next = queue.poll();
            if (next[0] == n - 1 && next[1] == m - 1) {
                return next[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = next[0] + dx[i];
                int ny = next[1] + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m ||
                    maps[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }
                
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, next[2] + 1});
            }
        }
        
        return -1;
    }
}