import java.util.*;
import java.io.*;

public class Main {
    static int N, S, sum = 0, answer = 0;
    static int[] numbers;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int depth, int index) {
        if(sum == S && depth > 0) {
            answer++;
        }

        for (int i = index; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sum += numbers[i];
                dfs(depth + 1, i + 1);
                visited[i] = false;
                sum -= numbers[i];
            }
        }
    }
}