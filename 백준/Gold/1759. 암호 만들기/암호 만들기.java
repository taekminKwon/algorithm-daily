import java.util.*;
import java.io.*;

public class Main {
    static char[] letters, password, vowel;
    static boolean[] visited;
    static StringBuilder sb;
    static int L, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        vowel = new char[]{'a', 'e', 'i', 'o', 'u'};
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[C];
        st = new StringTokenizer(br.readLine());
        letters = new char[C];
        password = new char[L];
        for (int i = 0; i < C; i++) {
            letters[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(letters);
        dfs(0, 0, 0);
        System.out.println(sb);
    }

    static void dfs(int depth, int vowel, int index) {
        if(depth == L) {
            if(depth - vowel > 1 && vowel > 0) {
                for(char c : password) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }

        password[depth] = '0';
        for (int i = index; i < C; i++) {
            if(!visited[i]) {
                visited[i] = true;
                password[depth] = letters[i];
                int isVowel = 0;
                if(isVowel(password[depth])) {
                    isVowel++;
                }
                dfs(depth + 1, vowel + isVowel, i + 1);
                visited[i] = false;
            }
        }
    }

    static boolean isVowel(char c) {
        for (char value : vowel) {
            if (value == c)
                return true;
        }
        return false;
    }
}