import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static char[] word = new char[5];
    static final char[] vowels = {'A','E','I','O','U'};
    static String target;
    static int answer;
    public int solution(String word) {
        target = word;
        dfs(0);
        return answer;
    }
    
    static void dfs(int depth) {
        if (depth == 5) {
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            word[depth] = vowels[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= depth; j++) {
                sb.append(word[j]);
            }
            list.add(sb.toString());
            
            if (target.equals(sb.toString())) {
                answer = list.size();
                return;
            }
            
            if (answer != 0) {
                return;
            }
            
            dfs(depth + 1);   
        }
    }
}