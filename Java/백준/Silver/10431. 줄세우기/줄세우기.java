import java.io.*;
import java.util.*;

public class Main {
    static int TOTAL_STUDENT = 20;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < P; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int answer = 0;
            int[] arr = new int[20];
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < TOTAL_STUDENT; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            list.add(arr[0]);
            loop:
            for (int student = 1; student < TOTAL_STUDENT; student++) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) > arr[student]) {
                        answer += list.size() - i;
                        list.add(i, arr[student]);
                        continue loop;
                    }
                }

                list.add(arr[student]);
            }

            sb.append(T).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
