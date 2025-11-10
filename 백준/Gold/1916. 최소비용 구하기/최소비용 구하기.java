import java.util.*;
import java.io.*;

class Main {
    static class Edge implements Comparable<Edge> {
        int dest;
        int weight;
        @Override
        public int compareTo(Edge o1) {
            return this.weight - o1.weight;
        }

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static int[] distance;
    static ArrayList<ArrayList<Edge>> nodes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i < N + 1; i++) {
            nodes.add(new ArrayList<>());
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes.get(from).add(new Edge(to, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int departure = Integer.parseInt(st.nextToken());
        int arrival = Integer.parseInt(st.nextToken());
        distance[departure] = 0;
        dijkstra(departure, arrival);

        System.out.println(distance[arrival]);
    }

    static void dijkstra(int departure, int arrival) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(departure, 0));

        while(!pq.isEmpty()) {
            Edge start = pq.poll();

            if (start.dest == arrival) {
                break;
            }
            
            if (distance[start.dest] < start.weight) {
                continue;
            }

            for (Edge dest : nodes.get(start.dest)) {
                if(distance[dest.dest] > dest.weight + distance[start.dest]) {
                    distance[dest.dest] = dest.weight + distance[start.dest];
                    pq.add(new Edge(dest.dest, distance[dest.dest]));
                }
            }
        }
    }
}