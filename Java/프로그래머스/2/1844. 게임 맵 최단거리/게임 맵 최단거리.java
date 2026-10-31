import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    public int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Deque<int[]> queue = new ArrayDeque<>();
        
        queue.add(new int[]{0, 0, 1});
        maps[0][0] = 0;
        while(!queue.isEmpty()) {
            int[] next = queue.poll();
            
            int x = next[0];
            int y = next[1];
            int movements = next[2];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || maps[nx][ny] == 0) {
                    continue;
                }
                
                if (nx == n - 1 && ny == m - 1) {
                    return movements + 1;
                }
                
                // 방문처리
                maps[nx][ny] = 0;
                
                queue.add(new int[]{nx, ny, movements + 1});
                
            }
        }
        
        return -1;
    }
}