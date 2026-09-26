import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Map<Integer, Integer> counts = new HashMap<>();
        boolean[] visited = new boolean[priorities.length];
        for (int i = 0; i < priorities.length; i++) {
            counts.put(priorities[i], counts.getOrDefault(priorities[i], 0) + 1);
        }

        List<Integer> list = new ArrayList<>(counts.keySet());
        list.sort(Collections.reverseOrder());
        Queue<Integer> queue = new LinkedList<>();
        
        int index = 0;
        int listIndex = 0;
        int count = 0;
        
        while (queue.size() < priorities.length) {
            index %= priorities.length;
            
            int priority = list.get(listIndex);
            
            if (visited[index] || priority > priorities[index]) {
                index++;
                continue;
            }
            
            visited[index] = true;
            queue.add(index++);
            counts.put(priority, counts.get(priority) - 1);
            if (counts.get(priority) == 0) {
                listIndex++;
            }
        }
        
        index = 0;
        while(!queue.isEmpty()) {
            int next = queue.poll();
            if (next == location) {
                return index + 1;
            }
            index++;
        }
        
        return -1;
    }
}