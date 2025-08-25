import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int answer, totalPopulation = 0;
    static List<Integer>[] lists;
    static int[] team, population;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lists = new List[N];
        team = new int[N];
        for (int i = 0; i < N; i++) {
            lists[i] = new ArrayList<>();
        }

        population = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            totalPopulation += population[i];
        }
        answer = totalPopulation;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int nextNode = Integer.parseInt(st.nextToken()) - 1;
                lists[i].add(nextNode);
                lists[nextNode].add(i);
            }
        }
        combination(0);
        if(answer == totalPopulation) {
            answer = -1;
        }
        System.out.println(answer);
    }

    static void combination(int depth) {
        if(depth == N) {
            isValid();
            return;
        }

        team[depth] = 1;
        combination(depth + 1);

        team[depth] = 2;
        combination(depth + 1);
    }

    static void isValid() {
        boolean checkedOne = false, checkedTwo = false;
        int teamOneSum = 0;
        int teamTwoSum = 0;
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if(checkedOne && checkedTwo) {
                break;
            }

            if(team[i] == 1 && !checkedOne) {
                checkedOne = true;
                teamOneSum = bfs(i);
            } else if(team[i] == 2 && !checkedTwo){
                checkedTwo = true;
                teamTwoSum = bfs(i);
            }
        }

        boolean isValid = true;
        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                isValid = false;
                break;
            }
        }

        if(isValid) {
            answer = Math.min(Math.abs(teamOneSum - teamTwoSum), answer);
        }
    }

    static int bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        int total = 0;
        q.add(node);
        visited[node] = true;
        while(!q.isEmpty()) {
            int curr = q.poll();
            total += population[curr];
            for (int i = 0; i < lists[curr].size(); i++) {
                int next = lists[curr].get(i);
                if(!visited[next] && team[next] == team[curr]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        return total;
    }
}