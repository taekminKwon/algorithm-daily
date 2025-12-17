class Solution {
    static boolean[] isChecked = new boolean[9999999];
    static boolean[] visited;
    static int[] intNumbers;
    public int solution(String numbers) {
        int answer = 0;
        intNumbers = new int[numbers.length()];
        visited = new boolean[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            intNumbers[i] = numbers.charAt(i) - '0';
        }
        
        return dfs(0, 0);
    }
    
    static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    static int dfs(int index, int number) {
        int count = 0;
        
        for (int i = 0; i < intNumbers.length; i++) {
            if (visited[i]) {
                continue;
            }
            int newNumber = number * 10 + intNumbers[i];
            if (!isChecked[newNumber] && isPrime(newNumber)) {
                isChecked[newNumber] = true;
                count++;
            }
            
            visited[i] = true;
            count += dfs(i + 1, newNumber);
            visited[i] = false;
        }
        
        return count;
    }
}