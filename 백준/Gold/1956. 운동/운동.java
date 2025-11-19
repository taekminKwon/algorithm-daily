import java.util.*;
import java.io.*;

class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()) + 1;
        int E = Integer.parseInt(st.nextToken());
        int[][] distances = new int[V][V];
        for (int i = 1; i < V; i++) {
            Arrays.fill(distances[i], INF);
            distances[i][i] = 0;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            distances[a][b] = weight;
        }

        for (int k = 1; k < V; k++) {
            for (int i = 1; i < V; i++) {
                for (int j = 1; j < V; j++) {
                    if (distances[i][k] != INF && distances[k][j] != INF && distances[i][j] > distances[i][k] + distances[k][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }
        int answer = -1;
        for (int i = 1; i < V; i++) {
            for (int j = 1; j < V; j++) {
                if(distances[i][j] != INF && distances[j][i] != INF && i != j) {
                    answer = answer > 0 ? Math.min(distances[i][j] + distances[j][i], answer) : distances[i][j] + distances[j][i];
                }
            }
        }
        System.out.println(answer);
    }
}
