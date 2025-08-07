import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 0;
        int width = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[] dx = {1, -1 , 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1) {
                    int tempWidth = 1;
                    queue.add(new int[]{i, j});
                    map[i][j] = 0;
                    while(!queue.isEmpty()) {
                        int[] point = queue.poll();
                        int x = point[0];
                        int y = point[1];
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] == 1) {
                                queue.add(new int[]{nx, ny});
                                map[nx][ny] = 0;
                                tempWidth++;
                            }
                        }
                    }
                    width = Math.max(tempWidth, width);
                    count++;
                }
            }
        }

        bw.write(count + "\n" + width);
        bw.flush();
        bw.close();
        br.close();
    }
}