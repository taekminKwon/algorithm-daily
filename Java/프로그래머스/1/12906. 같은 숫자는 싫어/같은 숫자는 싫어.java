import java.util.*;

public class Solution {
    public Deque<Integer> solution(int[] arr) {
        Deque<Integer> answer = new LinkedList<>();
        for (int i : arr) {
            if (!answer.isEmpty() && answer.getLast() == i) {
                continue;
            }
            answer.add(i);
        }
        
        return answer;
    }
}