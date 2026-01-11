import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] KBS = new int[2];
        for (int i = 0; i < N; i++) {
            String channel = br.readLine();
            if (channel.equals("KBS1")) {
                KBS[0] = i;
            }

            if (channel.equals("KBS2")) {
                KBS[1] = i;
            }
        }


        StringBuilder sb = new StringBuilder();
        int[] toGo = {0, 1};
        int curr = 0;
        for (int i = 0; i < KBS.length; i++) {
            if (KBS[i] != toGo[i]) {
                for (int j = 0; j < KBS[i] - curr; j++) {
                    sb.append("1");
                }

                for (int j = 0; j < KBS[i] - toGo[i]; j++) {
                    sb.append("4");
                }

                if (i < KBS.length - 1) {
                    if (KBS[i] > KBS[i + 1]) {
                        KBS[i + 1]++;
                    }
                }

                KBS[i] = toGo[i];
                curr = toGo[i];
            }
        }
        
        System.out.println(sb);
    }
}
