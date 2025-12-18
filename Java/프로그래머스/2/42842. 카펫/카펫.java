class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i = 1; i * i <= yellow; i++) {
            if ((i + 2) * (yellow / i + 2) == yellow + brown) {
                answer = new int[]{yellow / i + 2, i + 2};
            }
        }
        return answer;
    }
}