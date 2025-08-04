import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] list;
    static int count, infected;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        infected = 0;

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        int M = Integer.parseInt(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list[f].add(s);
            list[s].add(f);
        }

        visited[1] = true;
        dfs(1);
        System.out.println(infected);
    }

    static void dfs(int node) {
        if(node != 1){
            infected++;
        }

        if(list[node].isEmpty()) {
            return;
        }
        for(int i = 0; i < list[node].size(); i++) {
            int nextNode = list[node].get(i);
            if(!visited[nextNode]) {
                visited[nextNode] = true;
                dfs(nextNode);
            }
        }
    }
}