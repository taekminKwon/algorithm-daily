import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            days[i] = (100 - progresses[i]) % speeds[i] == 0 
                ? (100 - progresses[i]) / speeds[i] : (100 - progresses[i]) / speeds[i] + 1;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> completed = new ArrayList<>();
        queue.add(days[0]);
        
        for (int i = 1; i < days.length; i++) {
            if (!queue.isEmpty() && queue.peek() >= days[i]) {
                queue.add(days[i]);
                continue;
            }
            
            completed.add(queue.size());
            queue.clear();
            queue.add(days[i]);
        }
        
        if (!queue.isEmpty()) {
            completed.add(queue.size());
        }
        
        return completed.stream().mapToInt(i -> i).toArray();
    }
}