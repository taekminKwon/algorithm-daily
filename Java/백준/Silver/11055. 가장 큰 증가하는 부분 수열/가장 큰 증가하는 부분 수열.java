import java.util.*;
import java.io.*;

public class Main {
    static int[] numbers, dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        dp = new int[n];
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = numbers[0];

        for (int i = 0; i < n; i++) {
            dp[i] = numbers[i];
            for (int j = 0; j < i; j++) {
                if(numbers[i] > numbers[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + numbers[i]);
                }
            }
            answer = Math.max(dp[i], answer);
        }
        System.out.println(answer);
    }
}