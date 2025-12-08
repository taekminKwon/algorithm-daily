import java.util.*;
import java.io.*;

class Main {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        map = new char[N][];

        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs(N, M));
    }

    static int bfs(int N, int M) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == N - 1 && curr[1] == M - 1) {
                return curr[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == '0') {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, curr[2] + 1});
            }
        }

        return -1;
    }
}