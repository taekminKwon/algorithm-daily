import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        String answer = "";
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for (String name : completion) {
            int count = map.get(name) - 1;
            if (count == 0) {
                map.remove(name);
                continue;
            }
            
            map.put(name, count);
        }
        
        for (String name : participant) {
            if (map.containsKey(name)) {
                answer = name;
                break;
            }
        }
    
        return answer;
    }
}