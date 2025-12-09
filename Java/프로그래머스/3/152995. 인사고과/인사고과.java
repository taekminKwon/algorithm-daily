import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int n = scores.length;
        int wanhoAtt = scores[0][0];
        int wanhoPeer = scores[0][1];
        int wanhoSum = wanhoAtt + wanhoPeer;

        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]); 
            }
            return Integer.compare(b[0], a[0]); 
        });

        int maxPeer = 0;
        List<Integer> validSums = new ArrayList<>();

        for (int[] s : scores) {
            int att = s[0];
            int peer = s[1];

            if (peer < maxPeer) {
                if (att == wanhoAtt && peer == wanhoPeer) {
                    return -1;
                }
                continue;
            }

            maxPeer = Math.max(maxPeer, peer);
            validSums.add(att + peer);
        }

        validSums.sort((a, b) -> Integer.compare(b, a));

        int rank = 1;
        for (int sum : validSums) {
            if (sum > wanhoSum) {
                rank++;
            } else {
                break;
            }
        }

        return rank;
    }
}
