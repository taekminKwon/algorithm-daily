import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>(Arrays.asList());
        
        int length = progresses.length;
        
        for (int i = 0; i < length; i++) {
            q.add(i);
        }
        
        int nextProgress = 0;
        
        List<Integer> answer = new ArrayList<>();
        int progressDone = 0;
        
        while (progressDone < length) {
            // 미완료 작업
            int next = q.peek();
            
            // 오늘 작업 진척
            for (int i = next; i < length; i++) {
                if (i < length) {
                    progresses[i] += speeds[i];
                }
            }
            
            // 오늘 배포된 작업
            int done = 0;
            
            while(!q.isEmpty() && progresses[q.peek()] >= 100) {
                q.poll();
                done++;
            }
            
            if (done > 0) {
                answer.add(done);
                progressDone += done;
            }
        }
        
        return answer;
    }
}