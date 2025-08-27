import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int answer = N + 1;
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[N + 1];
        sum[0] = 0;
        for (int i = 1; i < N + 1; i++) {
            sum[i] += sum[i - 1] + arr[i - 1];
        }
        int f = 0;
        int s = 0;
        int target = 0;
        while(f < N) {
            while(f < N && target < S) {
                f++;
                target = sum[f] - sum[s];
            }

            if(target >= S) {
                answer = Math.min(answer, f - s);
            }

            while(target >= S) {
                s++;
                target = sum[f] - sum[s];
            }

            if(s > 0 && sum[f] - sum[s - 1] >= S) {
                answer = Math.min(answer, f - s + 1);
            }
        }

        if(answer == N + 1) {
            answer = 0;
        }
        System.out.println(answer);
    }
}