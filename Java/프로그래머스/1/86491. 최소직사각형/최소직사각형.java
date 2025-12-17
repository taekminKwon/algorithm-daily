class Solution {
    public int solution(int[][] sizes) {
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                swap(sizes[i]);
            }
        }
        
        int maxWidth = 0;
        int maxHeight = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (maxWidth < sizes[i][0]) {
                maxWidth = sizes[i][0];
            }
            
            if (maxHeight < sizes[i][1]) {
                maxHeight = sizes[i][1];
            }
        }
        
        return maxWidth * maxHeight;
    }
    
    static void swap(int[] sizes) {
        int temp = sizes[0];
        sizes[0] = sizes[1];
        sizes[1] = temp;
    }
}