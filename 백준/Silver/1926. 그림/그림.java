import java.util.*;
import java.io.*;

class Main {
    static int[][] picture;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static int counts = 0, width = 0, n, m;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        picture = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && picture[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(counts);
        System.out.println(width);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        counts++;
        queue.add(new int[]{x, y});
        int pictureWidth = 1;
        while(!queue.isEmpty()) {
            int[] position = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = position[0] + dx[i];
                int ny = position[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || picture[nx][ny] == 0) {
                    continue;
                }
                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                pictureWidth++;
            }
        }
        width = Math.max(width, pictureWidth);
    }
}
