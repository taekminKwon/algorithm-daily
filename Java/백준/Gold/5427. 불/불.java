import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int test_case = Integer.parseInt(br.readLine());
        a:
        for (int T = 0; T < test_case; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int answer = 0;
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            char[][] building = new char[h][w];
            boolean[][] visited = new boolean[h][w];
            Queue<int[]> s = new LinkedList<>();
            Queue<int[]> fire = new LinkedList<>();
            for (int i = 0; i < h; i++) {
                building[i] = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    if(building[i][j] == '@') {
                        s.add(new int[]{i, j});
                    } else if(building[i][j] == '*') {
                        fire.add(new int[]{i, j});
                    }
                }
            }

            while(!s.isEmpty()) {
                int fires = fire.size();
                int ss = s.size();
                answer++;
                for (int i = 0; i < fires; i++) {
                    int[] position = fire.poll();
                    for (int j = 0; j < 4; j++) {
                        int ny = position[0] + dy[j];
                        int nx = position[1] + dx[j];
                        if(0 <= nx && nx < w && 0 <= ny && ny < h && (building[ny][nx] == '.' || building[ny][nx] == '@')) {
                            building[ny][nx] = '*';
                            fire.add(new int[]{ny, nx});
                        }
                    }
                }

                for (int i = 0; i < ss; i++) {
                    int[] position = s.poll();
                    for (int j = 0; j < 4; j++) {
                        int ny = position[0] + dx[j];
                        int nx = position[1] + dy[j];
                        if(0 <= nx && nx < w && 0 <= ny && ny < h && building[ny][nx] == '.' && !visited[ny][nx]) {
                            building[ny][nx] = '@';
                            s.add(new int[]{ny, nx});
                            visited[ny][nx] = true;
                        }
                        if(nx == -1 || ny == -1 || nx == w || ny == h) {
                            sb.append(answer).append("\n");
                            continue a;
                        }
                    }
                }
            }
            sb.append("IMPOSSIBLE\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
