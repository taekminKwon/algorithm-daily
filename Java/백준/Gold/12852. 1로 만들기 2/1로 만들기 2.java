import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N + 1];
        Map<Integer, Integer> map = new HashMap<>();
        arr[1] = 0;
        for (int i = 2; i <= N; i++) {
            int num1 = i % 3 == 0 ? arr[i / 3]: Integer.MAX_VALUE;
            int num2 = i % 2 == 0 ? arr[i / 2]: Integer.MAX_VALUE;
            arr[i] = Math.min(Math.min(num1, num2), arr[i - 1]) + 1;
            if (arr[i] == num1 + 1) {
                map.put(i, i / 3);
            } else if (arr[i] == num2 + 1) {
                map.put(i, i / 2);
            } else {
                map.put(i, i - 1);
            }
        }
        sb.append(arr[N]).append("\n");
        while (N > 0) {
            sb.append(N).append(" ");
            N = map.getOrDefault(N, 0);
        }
        System.out.println(sb);
    }
}