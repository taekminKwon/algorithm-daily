import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        String answer = "";
        for (String name : completion) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for (String name : participant) {
            int count = map.getOrDefault(name, 0) - 1;
            if (count < 0) {
                answer = name;
            }
            map.put(name, count);
        }
    
        return answer;
    }
}