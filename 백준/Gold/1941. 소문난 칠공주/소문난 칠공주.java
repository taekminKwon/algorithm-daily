import java.util.*;
import java.io.*;

public class Main {
    static boolean[] isSeated;
    static char[][] classroom;
    static int[] dx = {5, -5, 1, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        classroom = new char[5][];
        isSeated = new boolean[25];
        for (int i = 0; i < 5; i++) {
            classroom[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < 25; i++) {
            int S = classroom[i / 5][i % 5] == 'S' ? 1 : 0;
            int Y = classroom[i / 5][i % 5] == 'Y' ? 1 : 0;
            isSeated[i] = true;
            dfs(i, 1, S, Y);
            isSeated[i] = false;
        }

        System.out.println(answer);
    }

    public static boolean bfs(int lastNode) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[25];
        boolean isValid = false;

        int visitedCount = 1;
        visited[lastNode] = true;
        queue.add(lastNode);

        while(!queue.isEmpty()) {
            int position = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = position + dx[i];
                if(i == 2 && nx % 5 == 0) {
                    continue;
                }
                if(i == 3 && position % 5 == 0) {
                    continue;
                }

                if(0 <= nx && nx < 25) {
                    if(!visited[nx]) {
                        visited[nx] = true;
                        if(isSeated[nx]) {
                            queue.add(nx);
                            visitedCount++;
                        }
                    }
                }
            }

            if(visitedCount == 7) {
                isValid = true;
                break;
            }

        }
        return isValid;
    }

    public static void dfs(int currNode, int depth, int countS, int countY) {
        if(depth == 7) {
            if(countS >= 4){
                if (bfs(currNode)) {
                    answer++;
                }
            }
            return;
        }

        for (int i = currNode + 1; i < 25; i++) {
            isSeated[i] = true;
            int S = classroom[i / 5][i % 5] == 'S' ? 1 : 0;
            int Y = classroom[i / 5][i % 5] == 'Y' ? 1 : 0;
            dfs(i, depth + 1, countS + S, countY + Y);
            isSeated[i] = false;
        }
    }
}