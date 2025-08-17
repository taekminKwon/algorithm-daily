import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int answer = 0;
        Queue<int[]> ices = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0) {
                    ices.add(new int[]{i, j});
                }
            }
        }

        int date = 0;
        int[][] surrounds = new int[N][M];
        while (true) {
            ++date;
            int icesCount = ices.size();
            for (int i = 0; i < icesCount; i++) {
                int[] target = ices.poll();
                int count = 0;
                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + target[0];
                    int ny = dy[j] + target[1];
                    if(map[nx][ny] == 0) {
                        count++;
                    }
                }
                surrounds[target[0]][target[1]] = count;
                ices.add(target);
            }

            for (int i = 0; i < icesCount; i++) {
                int[] target = ices.poll();
                map[target[0]][target[1]] = Math.max(map[target[0]][target[1]] - surrounds[target[0]][target[1]], 0);
                if(map[target[0]][target[1]] > 0) {
                    ices.add(target);
                }
            }

            if(ices.isEmpty()) {
                break;
            }
            
            Queue<int[]> findIces = new LinkedList<>();
            findIces.add(ices.peek());
            visited = new boolean[N][M];
            visited[ices.peek()[0]][ices.peek()[1]] = true;
            int linkedCount = 0;
            while(!findIces.isEmpty()) {
                int[] target = findIces.poll();
                linkedCount++;
                for (int i = 0; i < 4; i++) {
                    int nx = dx[i] + target[0];
                    int ny = dy[i] + target[1];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }

                    if(map[nx][ny] > 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        findIces.add(new int[]{nx, ny});
                    }
                }
            }

            if(linkedCount != ices.size()) {
                answer = date;
                break;
            }
        }

        System.out.println(answer);
    }
}
