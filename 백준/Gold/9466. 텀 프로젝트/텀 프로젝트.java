import java.util.*;
import java.io.*;

public class Main{
    static int[] students;
    static boolean[] visited, finished;
    static int answer;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            answer = 0;
            students = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if(!finished[i]) {
                    dfs(i);
                }
            }

            sb.append(n - answer).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int curr) {
        if(finished[curr]) {
            return;
        }

        if(visited[curr]) {
            finished[curr] = true;
            answer++;
        }

        visited[curr] = true;
        dfs(students[curr]);
        finished[curr] = true;
        visited[curr] = false;
    }
}