import java.util.*;
import java.io.*;

class Main {
    static int[] nodes;
    static int[] ranking;
    static class Edge implements Comparable<Edge> {
        int weight;
        int from;
        int to;
        Edge(int weight, int from, int to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Edge o1) {
            return Integer.compare(this.weight, o1.weight);
        }
    }

    public static int find(int target) {
        if (nodes[target] == target) {
            return target;
        }
        int next = find(nodes[target]);
        nodes[target] = next;
        return next;
    }

    public static int union(Edge e) {
        int headA = find(e.from);
        int headB = find(e.to);
        if (headA == headB) {
            return 0;
        }
        if (ranking[headA] > ranking[headB]) {
            nodes[headB] = headA;
        } else if (ranking[headB] > ranking[headA]) {
            nodes[headA] = headB;
        } else {
            nodes[headB] = headA;
            ranking[headA]++;
        }

        return e.weight;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int answer = 0;
        nodes = new int[V + 1];
        ranking = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            nodes[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Edge(weight, from, to));
        }

        while(!pq.isEmpty()) {
            answer += union(pq.poll());
        }
        System.out.println(answer);
    }
}