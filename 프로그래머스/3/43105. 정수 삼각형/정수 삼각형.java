class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int dx;
                if(0 < j && j < triangle[i].length - 1) {
                    dx = Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
                } else if (j == 0) {
                    dx = triangle[i - 1][j];
                } else {
                    dx = triangle[i - 1][j - 1];
                }
                triangle[i][j] = triangle[i][j] + dx;
            }
        }
        
        for(int i = 0; i < triangle[triangle.length - 1].length; i++) {
            answer = Math.max(triangle[triangle.length - 1][i], answer);            
        }
        return answer;
    }
}