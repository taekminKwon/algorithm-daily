class Solution {
    static int targetNumber, count = 0;
    static int[] staticNumbers;
    
    public void dfs(int depth, int total) {
        if (depth == staticNumbers.length) {
            if (total == targetNumber)
                count++;
            return;
        }

        dfs(depth + 1, total + staticNumbers[depth]);
        dfs(depth + 1, total + staticNumbers[depth] * -1);
    }
    
    public int solution(int[] numbers, int target) {
        staticNumbers = numbers;
        targetNumber = target;
        dfs(0, 0);
        return count;
    }
}