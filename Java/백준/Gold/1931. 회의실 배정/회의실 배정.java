import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (i1, i2) -> {
            if(i1[1] == i2[1]) {
                return i1[0] - i2[0];
            }

            return i1[1] - i2[1];
        });

        int[] session = arr[0];
        int count = 1;
        for (int i = 1; i < N; i++) {
            if(session[1] <= arr[i][0]) {
                count++;
                session = arr[i];
            }
        }

        System.out.println(count);
    }
}