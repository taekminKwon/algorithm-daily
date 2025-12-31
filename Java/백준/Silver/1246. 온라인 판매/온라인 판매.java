import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int maxTotal = 0;
        int answer = arr[0];
        for (int i = 0; i < M; i++) {
            int maxQuantity = Math.min(M - i, N);
            if (arr[i] * maxQuantity > maxTotal) {
                answer = arr[i];
                maxTotal = arr[i] * maxQuantity;
            }
        }

        System.out.println(answer + " " + maxTotal);
    }
}
