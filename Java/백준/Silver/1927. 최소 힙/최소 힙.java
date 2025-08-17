import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException   {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input > 0) {
                pq.add(input);
            } else {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll()).append("\n");
                }
                else{
                    sb.append("0").append("\n");
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}