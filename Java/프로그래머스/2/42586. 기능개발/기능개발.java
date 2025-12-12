import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        int[] completion = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            completion[i] = (100 - progresses[i]) % speeds[i] == 0 ? 
                (100 - progresses[i]) / speeds[i] :
                (100 - progresses[i]) / speeds[i] + 1;
        }
        List<Integer> answer = new ArrayList<>();
        int high = completion[0];
        int day = 0;
        for (int i = 0; i < completion.length; i++) {
            if (completion[i] <= high) {
                day++;
                continue;
            }
            answer.add(day);
            high = completion[i];
            day = 1;
        }
        answer.add(day);
        
        return answer;
    }
}