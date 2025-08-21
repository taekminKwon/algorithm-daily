import java.util.*;
import java.io.*;

public class Main {
    static int[] remainChickens;
    static int chickenN, M, minDistance;
    static List<int[]> homeList, chickenList;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        remainChickens = new int[M];
        minDistance = Integer.MAX_VALUE;
        int[][] map = new int[N][N];
        homeList = new ArrayList<>();
        chickenList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    homeList.add(new int[]{i, j});
                } else if(map[i][j] == 2) {
                    chickenList.add(new int[]{i, j});
                }
            }
        }
        chickenN = chickenList.size();
        visited = new boolean[chickenN];
        dfs(0, 0);
        System.out.println(minDistance);
    }

    static void dfs(int depth, int index) {
        if(depth == M) {
            minDistance = Math.min(getTotalDistance(), minDistance);
            return;
        }

        for (int i = index; i < chickenN; i++) {
            if(!visited[i]) {
                remainChickens[depth] = i;
                visited[i] = true;
                dfs(depth + 1, i + 1);
                remainChickens[depth] = -1;
                visited[i] = false;
            }
        }
    }

    static int getTotalDistance() {
        int totalDistance = 0;
        for(int[] home : homeList) {
            int distance = Integer.MAX_VALUE;
            for(int index : remainChickens) {
                int[] chicken = chickenList.get(index);
                distance = Math.min(distance, getDistance(chicken, home));
            }
            totalDistance += distance;
        }
        return totalDistance;
    }

    static int getDistance(int[] x, int[] y) {
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }
}