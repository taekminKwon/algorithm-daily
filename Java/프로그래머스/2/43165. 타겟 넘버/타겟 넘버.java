class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(0, 0, numbers, target);
    }
    
    public int dfs(int total, int depth, int[] numbers, int target) {
        if (depth == numbers.length) {
            if (target == total) {
                return 1;
            }
            
            return 0;
        }
        
        return dfs(total + numbers[depth], depth + 1, numbers, target) + dfs(total - numbers[depth], depth + 1, numbers, target);
    }
}