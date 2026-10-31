import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        Arrays.sort(phone_book, (a, b) -> {
            return Integer.compare(a.length(), b.length());
        });
        
        for (String phoneNumber : phone_book) {
            for (int i = 1; i < phoneNumber.length(); i++) {
                if (set.contains(phoneNumber.substring(0, i))) {
                    return false;
                }
            }
            set.add(phoneNumber);
        }
        
        return true;
    }
}