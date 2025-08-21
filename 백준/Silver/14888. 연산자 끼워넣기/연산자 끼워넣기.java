import java.util.*;
import java.io.*;

public class Main {
    static int[] numbers, operators;
    static int N, maxValue, minValue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        maxValue = Integer.MIN_VALUE;
        minValue = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, numbers[0]);
        sb.append(maxValue).append('\n').append(minValue);
        System.out.println(sb);
        br.close();
    }

    static void dfs(int depth, int result) {
        if(depth == N - 1) {
            maxValue = Math.max(result, maxValue);
            minValue = Math.min(result, minValue);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(operators[i] > 0) {
                operators[i] -= 1;
                dfs(depth + 1, calculate(result, numbers[depth + 1], i));
                operators[i] += 1;
            }
        }
    }

    static int calculate(int i, int j, int operator) {
        switch(operator) {
            case 0:
                return i + j;
            case 1:
                return i - j;
            case 2:
                return i * j;
            default:
                return i / j;
        }
    }
}