import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int count = 0;
        Arrays.sort(targets, (o1, o2) -> {
            if (o1[0] == o2[0]){
                return Integer.compare(o1[1], o2[1]);
            }
            
            return Integer.compare(o1[0], o2[0]);
        });
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });
        
        int index = 0;
        while (index < targets.length) {
            // 꼬리가 새로 들어오는거보다 작으면
            if (!pq.isEmpty() && pq.peek()[1] <= targets[index][0]) {
                count++;
                
                while(!pq.isEmpty()) {
                    pq.poll();
                }
            }
            
            pq.add(targets[index++]);
        }
        
        return count + 1;
    }
}