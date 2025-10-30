import java.util.*;
import java.io.*;

public class Main {
    static int[] ranking, nodes;
    static long answer = 0;
    static boolean union(Edge e) {
        int a = e.from;
        int b = e.to;
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return false;
        }

        if (ranking[pa] > ranking[pb]) {
            nodes[pb] = pa;
        } else if (ranking[pb] > ranking[pa]) {
            nodes[pa] = pb;
        } else {
            nodes[pb] = pa;
            ranking[pa]++;
        }
        answer += e.weight;
        return true;
    }

    static int find(int node) {
        if (nodes[node] == node) {
            return node;
        }

        int p = find(nodes[node]);
        nodes[node] = p;
        return p;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nodes = new int[N];
        ranking = new int[N];
        int E = 0;
        for (int i = 0; i < N; i++) {
            nodes[i] = i;
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int weight = Integer.parseInt(st.nextToken());
                if(i >= j) continue;
                edges.add(new Edge(weight, i, j));
            }
        }

        while (!edges.isEmpty()) {
            if (E == N - 1) {
                break;
            }

            if(union(edges.poll())) {
                E++;
            }
        }
        System.out.println(answer);
    }

    static class Edge implements Comparable<Edge> {
        int weight, from, to;
        Edge(int weight, int from, int to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}