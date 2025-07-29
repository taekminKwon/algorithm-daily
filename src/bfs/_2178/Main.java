package bfs._2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[N][M];

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Queue<int[]> q = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        q.add(new int[]{0, 0, });
        while(!q.isEmpty()) {
            int[] position = q.poll();
            visited[position[0]][position[1]] = true;

            if(position[0] == N - 1 && position[1] == M - 1) {
                answer = position[2];
                break;
            }
            for (int k = 0; k < 4; k++) {
                int nx = position[0] + dx[k];
                int ny = position[1] + dy[k];
                if(0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && map[nx][ny] == '1') {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, position[2] + 1});
                }
            }
        }

        System.out.println(answer);
    }
}

