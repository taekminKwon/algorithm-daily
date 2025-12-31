import java.io.*;
import java.util.*;

public class Main {
    static final int[] numbers = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    static int[] equation = new int[6];
    static int used;
    static boolean found = false;
    static String[] str = new String[8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str[2] = "+";
        str[5] = "=";
        used = Integer.parseInt(br.readLine()) - 4;

        dfs(0);
        if (found) {
            System.out.println(String.join("", str));
        } else {
            System.out.println("impossible");
        }
    }

    static void dfs(int depth) {
        if (used < 0) {
            return;
        }

        if (depth == 6) {
            if (used == 0) {
                int index = 0;
                if (equation[0] * 10 + equation[1] + equation[2] * 10 + equation[3] == equation[4] * 10 + equation[5]) {
                    found = true;
                }

                if (found) {
                    for (int i = 0; i < 8; i++) {
                        if (str[i] == null) {
                            str[i] = String.valueOf(equation[index++]);
                        }
                    }
                }
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (found) {
                return;
            }

            used -= numbers[i];
            equation[depth] = i;
            dfs(depth + 1);
            used += numbers[i];
        }
    }
}
