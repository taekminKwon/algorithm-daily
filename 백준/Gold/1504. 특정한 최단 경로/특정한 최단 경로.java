import java.util.*;
import java.io.*;

class Main {
    static ArrayList<Edge>[] lists;

    static class Edge implements Comparable<Edge> {
        int to;
        int weight;
        public int compareTo(Edge o1) {
            return Integer.compare(weight, o1.weight);
        }

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long answer = -1;
        int[] distanceS, distanceV1, distanceV2;
        distanceS = new int[N + 1];
        distanceV1 = new int[N + 1];
        distanceV2 = new int[N + 1];
        Arrays.fill(distanceS, Integer.MAX_VALUE);
        Arrays.fill(distanceV1, Integer.MAX_VALUE);
        Arrays.fill(distanceV2, Integer.MAX_VALUE);

        lists = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        int E = Integer.parseInt(st.nextToken());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lists[a].add(new Edge(b, c));
            lists[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        dijkstra(1, distanceS);
        dijkstra(v1, distanceV1);
        dijkstra(v2, distanceV2);

        int sToV1 = distanceS[v1];
        int V1ToV2 = distanceV1[v2];
        int V2ToN = distanceV2[N];
        int sToV2 = distanceS[v2];
        int V2ToV1 = distanceV2[v1];
        int V1ToN = distanceV1[N];
        if(sToV1 != Integer.MAX_VALUE && V1ToV2 != Integer.MAX_VALUE && V2ToN != Integer.MAX_VALUE) {
            answer = sToV1 + V1ToV2 + V2ToN;
        }
        if(sToV2 != Integer.MAX_VALUE && V2ToV1 != Integer.MAX_VALUE && V1ToN != Integer.MAX_VALUE) {
            answer = answer > 0 ? Math.min(sToV2 + V2ToV1 + V1ToN, answer) : sToV2 + V2ToV1 + V1ToN;
        }

        System.out.println(answer);
    }

    private static void dijkstra(int start, int[] distance) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        distance[start] = 0;
        while(!pq.isEmpty()) {
            Edge from = pq.poll();
            if (distance[from.to] < from.weight) {
                continue;
            }

            for (Edge dest : lists[from.to]) {
                if (distance[dest.to] > from.weight + dest.weight) {
                    distance[dest.to] = from.weight + dest.weight;
                    pq.add(new Edge(dest.to, distance[dest.to]));
                }
            }
        }
    }
}