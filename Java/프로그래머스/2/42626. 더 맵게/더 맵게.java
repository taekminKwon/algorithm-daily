import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add(i);
        }
        
        while(pq.size() > 1 && pq.peek() < K) {
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + b * 2);
            answer++;
        }
        
        if (!pq.isEmpty() && pq.peek() >= K) {
            return answer;
        }
        
        return -1;
    }
}