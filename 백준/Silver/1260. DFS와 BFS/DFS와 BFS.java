import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] list;
    static StringBuilder sb;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 0; i <= N; i++) {
            Collections.sort(list[i]);
        }

        dfs(V);
        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);
    }

    static void dfs(int V) {
        visited[V] = true;
        sb.append(V).append(' ');
        for (int i = 0; i < list[V].size(); i++) {
            if(!visited[list[V].get(i)]) {
                visited[list[V].get(i)] = true;
                dfs(list[V].get(i));
            }
        }
    }

    static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = true;
        while(!queue.isEmpty()) {
            int position = queue.poll();
            sb.append(position).append(' ');
            for(int i = 0; i < list[position].size(); i++) {
                int nextNode = list[position].get(i);
                if(!visited[nextNode]) {
                    queue.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }


}