import java.util.*;
import java.io.*;

class Main {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) + 1;
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] distances = new int[n][n];
        for (int[] distance : distances) {
            Arrays.fill(distance, INF);
        }

        for (int i = 0; i < n; i++) {
            distances[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            distances[start][end] = Math.min(weight, distances[start][end]);
        }

        for (int k = 1; k < n; k++) {
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (distances[i][k] != INF && distances[k][j] != INF && distances[i][k] + distances[k][j] < distances[i][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if(distances[i][j] != INF)
                    sb.append(distances[i][j]).append(' ');
                else
                    sb.append(0).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}