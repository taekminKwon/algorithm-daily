import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> queue = new LinkedList<>();
        for (int i : arr) {
            if (queue.isEmpty() || queue.getLast() != i) {
                queue.add(i);
            }
        }
        
        int[] answer = new int[queue.size()];
        int index = 0;
        while (!queue.isEmpty()) {
            answer[index++] = queue.poll();
        }
        
        return answer;
    }
}