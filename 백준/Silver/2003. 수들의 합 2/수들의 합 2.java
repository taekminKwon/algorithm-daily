import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i > 0) {
                arr[i] += arr[i - 1];
            }
        }
        int answer = 0;

        int first = 0;
        int last = 0;
        while (first < N) {
            while (first < N && arr[first] - arr[last] < M) {
                first++;
            }

            if (arr[first] - arr[last] == M) {
                answer++;
                first++;
            }

            if(first > N) {
                break;
            }

            while(arr[first] - arr[last] > M) {
                last++;
            }

            if (arr[first] - arr[last] == M) {
                answer++;
                last++;
            }
        }

        System.out.println(answer);
    }
}