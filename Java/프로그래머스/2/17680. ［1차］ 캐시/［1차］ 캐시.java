import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        int answer = 0;
        List<String> cacheList = new LinkedList<>();
        Set<String> cacheSet = new HashSet<>();
        
        for (String city : cities) {
            city = city.toLowerCase();
            if (cacheList.size() < cacheSize) {
                if (cacheSet.contains(city)) {
                    answer += 1;
                    cacheList.remove(city);
                    cacheList.add(0, city);
                } else {
                    answer += 5;
                    cacheList.add(0, city);
                    cacheSet.add(city);
                }
            } else {
                if (cacheSet.contains(city)) {
                    answer += 1;
                    cacheList.remove(city);
                    cacheList.add(0, city);
                } else {
                    answer += 5;
                    if(cacheList.size() > 0) {
                        String removed = cacheList.remove(cacheList.size() - 1);
                        cacheSet.remove(removed);
                    }
                    cacheList.add(0, city);
                    cacheSet.add(city);
                }
            }
        }
        
        return answer;
    }
}