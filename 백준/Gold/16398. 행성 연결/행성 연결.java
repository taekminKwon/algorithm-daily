import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 인접행렬 입력
        int[][] w = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        long answer = 0;
        for (int iter = 0; iter < N; iter++) {
            int u = -1, best = Integer.MAX_VALUE;
            // 아직 미방문 정점 중 dist 최소 찾기 (O(N))
            for (int i = 0; i < N; i++) {
                if (!visited[i] && dist[i] < best) {
                    best = dist[i];
                    u = i;
                }
            }
            // 연결 안 된 경우 처리(필요 시)
            if (u == -1) {
                // System.out.println("Disconnected");
                return;
            }

            visited[u] = true;
            answer += (iter == 0 ? 0 : best);

            // u를 통해 다른 정점까지의 거리 갱신 (O(N))
            for (int v = 0; v < N; v++) {
                if (!visited[v] && w[u][v] < dist[v]) {
                    dist[v] = w[u][v];
                }
            }
        }

        System.out.println(answer);
    }
}
