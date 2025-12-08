import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int days = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] box = new int[m][n];
        int[] dx = {1, -1 , 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> queue = new LinkedList<>();
        int tomatoes = 0;
        int red = 0;

        for (int i = 0; i < m; i++) {
            StringTokenizer boxLine = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                box[i][j] = Integer.parseInt(boxLine.nextToken());
                if(box[i][j] >= 0) {
                    tomatoes++;
                    if(box[i][j] == 1) {
                        queue.add(new int[]{i, j, 0});
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] place = queue.poll();
            red++;
            days = Math.max(place[2], days);
            for (int i = 0; i < 4; i++) {
                int nx = place[0] + dx[i];
                int ny = place[1] + dy[i];
                if(0 <= nx && nx < m && 0 <= ny && ny < n && box[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny, place[2] + 1});
                    box[nx][ny] = 1;
                }
            }
        }

        if(red != tomatoes) {
            days = -1;
        }

        bw.write(String.valueOf(days));
        bw.flush();
        bw.close();
        br.close();
    }
}