import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        
        for (int number : numbers) {
            list.add(number);
        }
        
        list.sort((a, b) -> {
            return Integer.parseInt(b + "" + a) - Integer.parseInt(a + "" + b);
        });
        
        StringBuilder sb = new StringBuilder();
        
        for (int i : list) {
            sb.append(i);
        }
        
        String answer = sb.toString();
        
        if (answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer;
    }
}