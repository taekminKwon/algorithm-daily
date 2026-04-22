import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1 -> 1
        // 2 ~ 7 -> 2 범위 6
        // 8 ~ 19 -> 3 범위 12
        // 20 ~ 37 -> 4 범위 18
        // 38 ~ 61 -> 5 범위 24
        int[] arr = new int[20000];
        int a = 1;
        arr[0] = 1;
        for (int i = 1; i < 20000; i++) {
            arr[i] = 6 * i;
        }
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 0; i < 20000; i++) {
            sum += arr[i];
            if (N <= sum) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}