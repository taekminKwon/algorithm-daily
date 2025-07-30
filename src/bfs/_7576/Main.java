package bfs._7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] box = new int[N][M];

        Queue<int[]> queue = new LinkedList<>();
        int tomatoes = 0;
        int holes = 0;
        int days = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) {
                    queue.add(new int[]{i, j, days});
                    tomatoes++;
                }

                if(box[i][j] != -1) {
                    holes++;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] position = queue.poll();
            days = position[2];
            for (int i = 0; i < 4; i++) {
                int nx = position[0] + dx[i];
                int ny = position[1] + dy[i];
                if(0 <= nx && nx < N && 0 <= ny && ny < M && box[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny, position[2] + 1});
                    box[nx][ny] = 1;
                    tomatoes++;
                }
            }
        }

        if(holes == tomatoes) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }
}
