import java.util.*;

class Solution {
    static Node[] nodeList;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        nodeList = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodeList[i] = new Node(i);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            nodeList[wire[0]].addWire(new Wire(i, wire[1]));
            nodeList[wire[1]].addWire(new Wire(i, wire[0]));
        }
        
        for (int wire = 0; wire < wires.length; wire++) {
            boolean[] visited = new boolean[n + 1];
            visited[1] = true;

            int sectionOne = dfs(0, 1, visited, wire);
            int sectionTwo = n - sectionOne;
            answer = Math.min(Math.abs(sectionOne - sectionTwo), answer);

        }
        
        return answer;
    }
    
    public static int dfs(int depth, int nodeNumber, boolean[] visited, int skipWire) {
        if (depth == visited.length) {
            return 0;
        }
        
        int value = 1;

        Node node = nodeList[nodeNumber];

        for (Wire wire : node.wires) {
            if (wire.index == skipWire || visited[wire.to]) {
                continue;
            }
            visited[wire.to] = true;
            value += dfs(depth + 1, wire.to, visited, skipWire);
        }

        
        return value;
    }
    
    public class Node {
        int number;
        List<Wire> wires = new ArrayList<>();
        
        public Node(int number) {
            this.number = number;
        }
        
        public void addWire(Wire wire) {
            wires.add(wire);
        }
    }
    
    public class Wire {
        int index;
        int to;
        
        public Wire (int index, int to) {
            this.index = index;
            this.to = to;
        }
    }
}