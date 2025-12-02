import java.util.*;
import java.io.*;

class Main {
    static final int R = 0, G = 1, B = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] paint = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            paint[i][R] = Integer.parseInt(st.nextToken());
            paint[i][G] = Integer.parseInt(st.nextToken());
            paint[i][B] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            paint[i][R] += Math.min(paint[i - 1][G], paint[i - 1][B]);
            paint[i][G] += Math.min(paint[i - 1][R], paint[i - 1][B]);
            paint[i][B] += Math.min(paint[i - 1][R], paint[i - 1][G]);
        }

        System.out.println(Math.min(paint[N - 1][R], Math.min(paint[N - 1][G], paint[N - 1][B])));
    }
}