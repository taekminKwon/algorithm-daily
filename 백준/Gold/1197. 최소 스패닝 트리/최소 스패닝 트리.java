import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int answer = 0;
        List<Node>[] lists = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        boolean[] visited = new boolean[V + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            lists[A].add(new Node(C, B));
            lists[B].add(new Node(C, A));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
        pq.add(new Node(0, 1));
        while(!pq.isEmpty()) {
            Node position = pq.poll();
            if(!visited[position.nextNode]) {
                visited[position.nextNode] = true;
                answer += position.weight;
                pq.addAll(lists[position.nextNode]);
            }
        }
        System.out.println(answer);
    }

    static class Node {
        int weight;
        int nextNode;

        public Node(int weight, int nextNode) {
            this.weight = weight;
            this.nextNode = nextNode;
        }
    }

    static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            return a.weight - b.weight;
        }
    }
}