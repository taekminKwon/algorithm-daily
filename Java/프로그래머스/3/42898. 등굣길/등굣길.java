import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] routes = new int[m][n];

        for (int[] puddle : puddles) {
            routes[puddle[0] - 1][puddle[1] - 1] = -1;
        }

        routes[0][0] = 1;

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (routes[x][y] == -1) continue;

                if (x > 0 && routes[x - 1][y] != -1) {
                    routes[x][y] += routes[x - 1][y];
                }

                if (y > 0 && routes[x][y - 1] != -1) {
                    routes[x][y] += routes[x][y - 1];
                }

                routes[x][y] %= 1000000007;
            }
        }

        return routes[m - 1][n - 1];
    }
}