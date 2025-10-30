import java.util.*;
import java.io.*;

public class Main {
    static Node[] nodes;
    static int[] ranking;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int E = 0;
        double answer = 0;
        nodes = new Node[N + 1];
        ranking = new int[N + 1];
        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i, i);
        }

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                edges.add(new Edge(i, j, getDistance(nodes[i], nodes[j])));
            }
        }



        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(union(nodes[start], nodes[end])) {
                E++;
            }
        }

        while (!edges.isEmpty()){
            Edge e = edges.poll();
            if (E == N - 1) {
                break;
            }
            if(union(nodes[e.start], nodes[e.end])) {
                E++;
                answer += e.weight;
            }
        }

        System.out.printf("%.2f", answer);
    }

    static class Node {
        int x, y, p, s;
        Node(int x, int y, int p, int s) {
            this.x = x;
            this.y = y;
            this.p = p;
            this.s = s;
        }
    }

    static class Edge implements Comparable<Edge> {
        int start, end;
        double weight;
        Edge(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.weight > o.weight) return 1;
            else if (this.weight == o.weight) return 0;
            return -1;
        }
    }

    static double getDistance(Node a, Node b) {
        long dx = (long)a.x - b.x;
        long dy = (long)a.y - b.y;
        return Math.sqrt((double)(dx*dx + dy*dy));
    }

    static boolean union(Node a, Node b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            if (ranking[pa] > ranking[pb]) {
                nodes[pb].p = pa;
            } else if (ranking[pb] > ranking[pa]) {
                nodes[pa].p = pb;
            } else {
                nodes[pb].p = pa;
                ranking[pa]++;
            }
            return true;
        }
        return false;
    }

    static int find(Node a) {
        if(a.p == a.s) {
            return a.s;
        }

        int p = find(nodes[a.p]);
        a.p = p;
        return p;
    }
}