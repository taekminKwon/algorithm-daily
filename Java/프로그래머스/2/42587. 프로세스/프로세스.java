import java.util.*;

class Process implements Comparable<Process> {
    int index;
    int priority;
    int count;
    Process (int index, int priority) {
        this.index = index;
        this.priority = priority;
        count = 0;
    }
    
    Process reProcessing() {
        this.count++;
        return this;
    }
    
    public int compareTo (Process p) {
        if (this.priority == p.priority) {
            if (this.count != p.count) {
                return Integer.compare(this.count, p.count);
            }
            
            return Integer.compare(this.index, p.index);
        }
        return Integer.compare(p.priority, this.priority);
    }
}
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Process> pq = new PriorityQueue<>();
        for (int i = 0; i < priorities.length; i++) {
            pq.add(new Process(i, priorities[i]));
        }
    
        int index = -1;
        int priority = 9;
        int answer = 0;
        while (!pq.isEmpty()) {
            Process curr = pq.poll();
            if (curr.count == 0 && priority > curr.priority && curr.index < index) {
                pq.add(curr.reProcessing());
                continue;
            }
            
            index = curr.index;
            priority = curr.priority;
            answer++;
            
            if (curr.index == location) {
                break;
            }
        }
        
        return answer;
    }
}