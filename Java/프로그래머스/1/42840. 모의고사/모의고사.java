import java.util.*;
class Solution {
    static final int[][] people = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
    public List<Integer> solution(int[] answers) {
        int[] counts = new int[people.length];
        int max = 0;
        for (int i = 0; i < people.length; i++) {
            int count = correction(answers, people[i]);
            max = Math.max(max, count);
            counts[i] = count;
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            if (counts[i] == max) {
                answer.add(i + 1);
            }
        }
        return answer;
    }
    
    static int correction(int[] answers, int[] person) {
        int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person[i % person.length]) {
                count++;
            }
        }
        
        return count;
    }
}