class Solution {
    static int max = 0;
    static boolean[] visited;
    
    public void dfs(int depth, int[][] dungeons, int left) {
        max = Math.max(max, depth);
        if (depth == visited.length) {
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++){
            int[] dungeon = dungeons[i];
            
            if (visited[i] || left < dungeon[0]) {
                continue;
            }
            
            visited[i] = true;
            dfs(depth + 1, dungeons, left - dungeon[1]);
            visited[i] = false;
        }
    }
    
    public int solution(int k, int[][] dungeons){
        visited = new boolean[dungeons.length];
        dfs(0, dungeons, k);
        return max;
    }
    
}