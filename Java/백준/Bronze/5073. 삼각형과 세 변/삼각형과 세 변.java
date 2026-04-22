import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < 3; i++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }

            int shortestLength = Integer.MAX_VALUE;
            int count = 0;
            int sum = 0;

            int a = pq.poll();
            int b = pq.poll();
            int c = pq.poll();

            if (a == 0 && b == 0 && c ==0) {
                break;
            }

            if (c >= a + b) {
                sb.append("Invalid\n");
                continue;
            }

            if (a == b && b == c) {
                sb.append("Equilateral\n");
                continue;
            }

            if (a == b || b == c) {
                sb.append("Isosceles\n");
                continue;
            }

            sb.append("Scalene\n");
        }

        System.out.println(sb);
    }
}