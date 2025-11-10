import java.util.*;
import java.io.*;

class Main {
    static int[] distance;
    static ArrayList<ArrayList<Node>> nodes;
    static class Node implements Comparable<Node> {
        int dest;
        int weight;

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o1) {
            return Integer.compare(this.weight, o1.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int V = Integer.parseInt(st.nextToken());
        distance = new int[V + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        nodes = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            nodes.add(new ArrayList<>());
        }

        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        distance[K] = 0;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes.get(from).add(new Node(to, weight));
        }

        dijkstra(K);
        for (int i = 1; i < V + 1; i++) {
            sb.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(distance[node.dest] < node.weight) {
                continue;
            }
            for(Node dest : nodes.get(node.dest)) {
                if (distance[dest.dest] > dest.weight + node.weight) {
                    distance[dest.dest] = dest.weight + node.weight;
                    pq.add(new Node(dest.dest, distance[dest.dest]));
                }
            }
        }
    }
}