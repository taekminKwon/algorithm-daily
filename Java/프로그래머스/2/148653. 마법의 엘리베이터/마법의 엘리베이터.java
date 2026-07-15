class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int current = storey % 10;
            int next = (storey / 10) % 10;

            if (current > 5 || (current == 5 && next >= 5)) {
                answer += 10 - current;
                storey += 10;
            } else {
                answer += storey % 10;
            }
            storey /= 10;
        }
        
        return answer;
    }
}