import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        boolean[] isRescued = new boolean[people.length];
        int rescued = 0;
        int smallIndex = 0;
        int bigIndex = people.length - 1;
        
        // System.out.println("Before loop : " + smallIndex + " " + bigIndex);
        while (rescued < people.length) {
            // System.out.println("loop " + rescued);
            if (isRescued[smallIndex]) {
                // System.out.println("Already Rescued " + smallIndex);
                smallIndex++;
                continue;
            }
            
            while (
                bigIndex > smallIndex
                && people[smallIndex] + people[bigIndex] > limit
            ) {
                bigIndex--;
            }
            
            isRescued[smallIndex] = true;
            rescued++;
            // System.out.print("rescued : " + smallIndex);
            
            if (smallIndex < bigIndex) {
                // System.out.print(" " + bigIndex);
                isRescued[bigIndex--] = true;
                rescued++;
            }
            
            smallIndex++;
            answer++;
        }
        
        return answer;
    }
}