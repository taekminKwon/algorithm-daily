import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        map.put("Y", 1);
        map.put("F", 2);
        map.put("O", 3);
        
        int gamer = map.get(st.nextToken());
        Set<String> played = new HashSet<>();
        int answer = 0;
        int currentPlayed = 0;
        for (int i = 0; i < N; i++) {
            String player = br.readLine();
            if (!played.contains(player)) {
                currentPlayed++;
                played.add(player);
            }

            if (currentPlayed == gamer) {
                answer++;
                currentPlayed = 0;
            }
        }
        System.out.println(answer);
    }
}
