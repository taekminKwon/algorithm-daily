import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int time = 0;
        int sharkSize = 2;
        int hasEaten = 0;
        PriorityQueue<Integer> fishSizes = new PriorityQueue<>();
        int[] sharkPosition = new int[]{-1, -1};
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) {
                    if (map[i][j] == 9) {
                        sharkPosition = new int[]{i, j, 0};
                        map[i][j] = 0;
                    } else {
                        fishSizes.add(map[i][j]);
                    }
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        while(!fishSizes.isEmpty() && fishSizes.peek() < sharkSize) {
            boolean[][] visited = new boolean[N][N];

            q.add(sharkPosition);
            visited[sharkPosition[0]][sharkPosition[1]] = true;
            int[] nextFish = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
            boolean isFound = false;
            while(!q.isEmpty()) {
                int[] position = q.poll();
                if(position[2] >= nextFish[2]) {
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = dx[i] + position[0];
                    int ny = dy[i] + position[1];
                    int nextTime = position[2] + 1;
                    if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        if (0 < map[nx][ny] && map[nx][ny] < sharkSize) {
                            if (nextFish[2] > nextTime) {
                                nextFish[0] = nx;
                                nextFish[1] = ny;
                                nextFish[2] = nextTime;
                                isFound = true;
                            } else if (nextFish[2] == nextTime) {
                                if (nx < nextFish[0]) {
                                    nextFish[0] = nx;
                                    nextFish[1] = ny;
                                } else if (nx == nextFish[0]) {
                                    if (ny < nextFish[1]) {
                                        nextFish[1] = ny;
                                    }
                                }
                            }
                        } else if (map[nx][ny] == sharkSize || map[nx][ny] == 0) {
                            q.add(new int[]{nx, ny, nextTime});
                        }
                    }
                }
            }

            if(isFound) {
                time += nextFish[2];
                sharkPosition = nextFish;
                sharkPosition[2] = 0;
                map[sharkPosition[0]][sharkPosition[1]] = 0;
                fishSizes.poll();
                hasEaten++;
                if(hasEaten == sharkSize) {
                    sharkSize++;
                    hasEaten = 0;
                }
            } else {
                break;
            }
        }

        System.out.println(time);
    }
}