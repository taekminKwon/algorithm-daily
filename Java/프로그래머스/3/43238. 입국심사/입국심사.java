class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long max = (long) times[0] * n;;
        long min = 0;
        
        while (min < max) {
            long mid = (max + min) / 2;
            long total = 0;
            for (int time : times) {
                total += mid / time;
            }
            
            if (total < n) {
                min = mid + 1; 
                continue;
            } else if (total >= n) {
                answer = mid;
            }
            
            max = mid;
        }
        
        return answer;
    }
}