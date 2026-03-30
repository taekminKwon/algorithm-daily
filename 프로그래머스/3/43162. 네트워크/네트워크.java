class Solution {
    static boolean[] visited;
    static int[][] staticComputers;
    static int N;
    static void dfs(int i) {
        visited[i] = true;
        for (int next = 0; next < N; next++) {
            if (staticComputers[i][next] == 1 && !visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        staticComputers = computers;
        N = n;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
}