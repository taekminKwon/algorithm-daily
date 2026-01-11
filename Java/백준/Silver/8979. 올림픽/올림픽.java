import java.io.*;
import java.util.*;

public class Main {
    static class Nation implements Comparable<Nation> {
        int index;
        int gold;
        int silver;
        int bronze;

        public Nation(int index, int gold, int silver, int bronze) {
            this.index = index;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public boolean equals(Nation n2) {
            return this.gold == n2.gold && this.silver == n2.silver && this.bronze == n2.bronze;
        }

        @Override
        public int compareTo(Nation n) {
            if (this.gold == n.gold) {
                if (this.silver == n.silver) {
                    return Integer.compare(n.bronze, this.bronze);
                }

                return Integer.compare(n.silver, this.silver);
            }

            return Integer.compare(n.gold, this.gold);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Nation> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());;
            int silver = Integer.parseInt(st.nextToken());;
            int bronze = Integer.parseInt(st.nextToken());;
            pq.add(new Nation(index, gold, silver, bronze));
        }
        List<Nation> list = new ArrayList<>();

        while(!pq.isEmpty()) {
            Nation nation = pq.poll();
            if (list.isEmpty() || !list.get(list.size() - 1).equals(nation)) {
                list.add(nation);
            }

            if (nation.index == K) {
                break;
            }
        }

        System.out.println(list.size());
    }
}
