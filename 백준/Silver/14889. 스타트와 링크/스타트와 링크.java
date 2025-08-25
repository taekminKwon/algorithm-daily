import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] synergy;
    static int[] team;
    static int teamOneCount = 0;
    static int teamTwoCount = 0;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        synergy = new int[N][N];
        team = new int[N];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                synergy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(answer);
    }
    
    static void dfs(int depth) {
        if(depth == N) {
            calculateAnswer();
            return;
        }

        if(teamOneCount < N / 2) {
            team[depth] = 1;
            teamOneCount++;
            dfs(depth + 1);
            teamOneCount--;
            team[depth] = 0;
        }

        if(teamTwoCount < N / 2) {
            team[depth] = 2;
            teamTwoCount++;
            dfs(depth + 1);
            teamTwoCount--;
            team[depth] = 0;
        }
    }

    private static void calculateAnswer() {
        int teamOnePoint = 0;
        int teamTwoPoint = 0;
        ArrayList<Integer> teamOne = new ArrayList<>();
        ArrayList<Integer> teamTwo = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if(team[i] == 1) {
                teamOne.add(i);
            } else {
                teamTwo.add(i);
            }
        }

        for (int i = 0; i < teamOne.size(); i++) {
            for (int j = i + 1; j < teamOne.size(); j++) {
                teamOnePoint += synergy[teamOne.get(i)][teamOne.get(j)] + synergy[teamOne.get(j)][teamOne.get(i)];
                teamTwoPoint += synergy[teamTwo.get(i)][teamTwo.get(j)] + synergy[teamTwo.get(j)][teamTwo.get(i)];
            }
        }

        int difference = Math.abs(teamOnePoint - teamTwoPoint);
        answer = Math.min(difference, answer);
    }
}