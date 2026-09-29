import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> deque = new LinkedList<>();
        int n = number.length();
        int index = 0;
        deque.add(number.charAt(index++));
        while (index < n) {
            char num = number.charAt(index);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() < num) {
                deque.pollLast();
                k--;
            }
            
            deque.addLast(num);
            index++;
        }
        
        while (k-- > 0) {
            deque.pollLast();
        }
        
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }
}