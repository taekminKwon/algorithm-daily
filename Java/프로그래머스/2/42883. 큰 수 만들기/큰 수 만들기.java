class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            arr[i] = number.charAt(i) - '0';
        }
        
        int index = 0;
        for (int i = 0; i < arr.length - k; i++) {
            int maxNumber = arr[index];
            int maxIndex = index;
            
            // number.size() - i  - 1까지만 고를 수 있게 하는데 그게 최대가 되게끔 -> 숫자 다 골라야하니까
            // 얼마나 남겨야하지 -> number.size() - k - i => 이거 만큼은 남겨야해
            // i
            for (int j = index; j <= k + i; j++) {
                if (arr[j] > maxNumber) {
                    maxIndex = j;
                    maxNumber = arr[j];
                }
            }

            index = maxIndex + 1;
            sb.append(maxNumber);
        }
        
        return sb.toString();
    }
}