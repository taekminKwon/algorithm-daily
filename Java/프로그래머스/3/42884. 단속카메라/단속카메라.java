import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int index = 0;
        int cameras = 0;
        
        while (index < routes.length) {
            int detection = routes[index][1];
            while (index < routes.length && detection >= routes[index][0]) {
                index++;
            }
            
            cameras++;
        }
        
        return cameras;
    }
}