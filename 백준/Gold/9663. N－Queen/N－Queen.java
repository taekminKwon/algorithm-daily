import java.util.*;
import java.io.*;

public class Main {
    static int[] chess;
    static int N, answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        chess = new int[N];
        Arrays.fill(chess, -1);
        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int depth) {
        if(depth == N) {
            answer++;
        }
        for (int i = 0; i < N; i++) {
            if(checkValid(depth, i)) {
                chess[depth] = i;
                dfs(depth + 1);
            }
        }
    }

    static boolean checkValid(int depth, int position) {
        for (int i = 0; i < depth; i++) {
            if(chess[i] == position) {
                return false;
            }
            if(Math.abs(chess[i] - position) == Math.abs(i - depth)) {
                return false;
            }
        }
        return true;
    }
}