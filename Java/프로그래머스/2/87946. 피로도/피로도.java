class Solution {
    static int max = 0;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons){
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return max;
    }
    
    static void dfs(int k, int[][] dungeons, int explored) {
        max = Math.max(explored, max);
        for (int i = 0; i < dungeons.length; i++) {
            if (k < dungeons[i][0] || visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(k - dungeons[i][1], dungeons, explored + 1);
            visited[i] = false;
        }
    }
}