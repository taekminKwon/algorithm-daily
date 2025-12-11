import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Set> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String[] cloth : clothes) {
            if (!map.containsKey(cloth[1])) {
                Set<String> set = new HashSet<>();
                set.add(cloth[0]);
                map.put(cloth[1], set);
                list.add(cloth[1]);
            } else {
                map.get(cloth[1]).add(cloth[0]);
            }
        }
        int answer = 1;
        for (String cloth : list) {
            answer *= map.get(cloth).size() + 1;
        }
        return answer - 1;
    }
}