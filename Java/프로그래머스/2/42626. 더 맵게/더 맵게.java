import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        while (pq.size() >= 2) {
            if (pq.peek() >= K) {
                return answer;
            }
            
            answer++;
            int s1 = pq.poll();
            int s2 = pq.poll();
            pq.add(s1 + s2 * 2);
        }
        
        if (pq.peek() >= K) {
            return answer;
        }
        return -1;
    }
}