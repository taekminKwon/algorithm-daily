import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        List<String> types = new ArrayList<>();
        
        for (String[] cloth : clothes) {
            String type = cloth[1]; 
            String name = cloth[0];
            
            if (!map.containsKey(type)) {
                types.add(type);
            }
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        
        for (String type : types) {
            answer *= map.get(type) + 1;
        }
        
        return answer - 1;
    }
}