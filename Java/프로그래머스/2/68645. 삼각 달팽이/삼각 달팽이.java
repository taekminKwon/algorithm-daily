class Solution {
    static final int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, -1}};
    public int[] solution(int n) {
        int[][] pyramids = new int[n][];
        boolean[][] visited = new boolean[n][];
        int total = n * (n + 1) / 2;
        int count = 1;
        int direction = 0;
        
        for (int i = 0; i < n; i++) {
            pyramids[i] = new int[i + 1];
            visited[i] = new boolean[i + 1];
        }
        
        int[] position = new int[]{0, 0};
        while (count < total) {
            if (pyramids[position[0]][position[1]] == 0) {
                pyramids[position[0]][position[1]] = count++;
                visited[position[0]][position[1]] = true;
            }

            int nx = position[0] + directions[direction][0];
            int ny = position[1] + directions[direction][1];
            
            while (nx < 0 || nx >= pyramids.length || ny < 0 || ny >= pyramids[nx].length || visited[nx][ny]) {
                direction = (direction + 1) % 3;
                nx = position[0] + directions[direction][0];
                ny = position[1] + directions[direction][1];
                continue;
            }
            
            position[0] = nx;
            position[1] = ny;
        }
        
        pyramids[position[0]][position[1]] = count;
        int[] answer = new int[total];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < pyramids[i].length; j++) {
                answer[index++] = pyramids[i][j];
            }
        }

        return answer;
    }
}
