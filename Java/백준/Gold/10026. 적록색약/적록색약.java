import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        char[][] picture = new char[N][];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int i = 0; i < N; i++) {
            picture[i] = br.readLine().toCharArray();
        }
        for (int times = 0; times < 2; times++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    char c = picture[i][j];
                    if (c == 'R' || c == 'G') {
                        picture[i][j] = 'Y';
                    }
                    if (!visited[i][j]) {
                        answer++;
                        queue.add(new int[]{i, j});
                        while (!queue.isEmpty()) {
                            int[] point = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = point[0] + dx[k];
                                int ny = point[1] + dy[k];
                                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                                    if (!visited[nx][ny] && picture[nx][ny] == c) {
                                        queue.add(new int[]{nx, ny});
                                        if (c == 'R' || c == 'G') {
                                            picture[nx][ny] = 'Y';
                                        }
                                        visited[nx][ny] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            visited = new boolean[N][N];
            sb.append(answer).append(' ');
            answer = 0;
        }
        System.out.println(sb.toString());
    }
}
