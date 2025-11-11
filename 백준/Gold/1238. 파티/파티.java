import java.util.*;
import java.io.*;

class Main {
    static int[][] distances;
    static int N;
    static ArrayList<ArrayList<Edge>> lists = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int answer = 0;
        N = Integer.parseInt(st.nextToken());
        distances = new int[N + 1][N + 1];
        for (int[] distance : distances) {
            Arrays.fill(distance, Integer.MAX_VALUE);
        }

        for (int i = 0; i < N + 1; i++) {
            lists.add(new ArrayList<>());
        }
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
           st = new StringTokenizer(br.readLine());
           int from = Integer.parseInt(st.nextToken());
           int to = Integer.parseInt(st.nextToken());
           int weight = Integer.parseInt(st.nextToken());
           lists.get(from).add(new Edge(to, weight));
        }

        for (int i = 1; i < N + 1; i++) {
            distances[i] = dijkstra(i);
        }

        for (int i = 1; i < N + 1; i++) {
            if (i != X) {
                answer = Math.max(answer, distances[i][X] + distances[X][i]);
            }
        }

        System.out.println(answer);
    }

    static class Edge implements Comparable<Edge> {
        int dest;
        int weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o1) {
            return Integer.compare(weight, o1.weight);
        }
    }

    static int[] dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Edge from = pq.poll();
            if (from.weight > distance[from.dest]) {
                continue;
            }

            for (Edge destination : lists.get(from.dest)) {
                int destMinWeight = Math.min(destination.weight, distances[from.dest][destination.dest]);
                if (distance[destination.dest] > from.weight + destMinWeight) {
                    distance[destination.dest] = from.weight + destMinWeight;
                    pq.add(new Edge(destination.dest, distance[destination.dest]));
                }
            }
        }
        return distance;
    }
}