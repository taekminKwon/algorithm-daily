import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, N, sum = 0;
    static int[] numbers, operator;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        operator = new int[4];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        sum = numbers[0];
        dfs(0);
        sb.append(max).append("\n").append(min);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if(depth == N - 1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(operator[i] > 0) {
                int result = calculate(i, sum, numbers[depth + 1]);
                int temp = sum;
                sum = result;
                operator[i]--;
                dfs(depth + 1);
                sum = temp;
                operator[i]++;
            }
        }
    }

    static int calculate(int operator, int a, int b) {
        switch (operator) {
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            default:
                return a / b;
        }
    }
}