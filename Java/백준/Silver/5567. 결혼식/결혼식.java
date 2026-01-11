import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    static List<Integer>[] friends;
    static boolean[] visited;
    static class Friend {
        int index;
        int depth;
        Friend(int index, int depth) {
            this.index = index;
            this.depth = depth;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) + 1;
        int m = Integer.parseInt(br.readLine());
        friends = new List[n];
        visited = new boolean[n];
        for (int i = 1; i < n; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }

        bfs(1);
        System.out.println(answer - 1);
    }

    private static void bfs(int i) {
        Queue<Friend> queue = new LinkedList<>();
        queue.add(new Friend(1, 0));
        visited[i] = true;
        while(!queue.isEmpty()) {
            Friend curr = queue.poll();
            answer++;
            if (curr.depth >= 2) {
                continue;
            }

            for (int friend : friends[curr.index]) {
                if (visited[friend]) {
                    continue;
                }
                queue.add(new Friend(friend, curr.depth + 1));
                visited[friend] = true;
            }
        }
    }
}
