import java.util.*;

class Solution {
    static class Process implements Comparable<Process> {
        int index;
        int requestTime;
        int processTime;
        Process (int index, int requestTime, int processTime) {
            this.index = index;
            this.requestTime = requestTime;
            this.processTime = processTime;
        }
        
        @Override
        public int compareTo(Process p) {
            return Integer.compare(this.processTime, p.processTime);
        }
    }
        
    public int solution(int[][] jobs) {
        PriorityQueue<Process> pq = new PriorityQueue<>();
        int[] turnAroundTimes = new int[jobs.length];
        int time = 0;
        int index = 0;
        Process[] processes = new Process[jobs.length];
        for (int i = 0; i < jobs.length; i++) {
            processes[i] = new Process(i, jobs[i][0], jobs[i][1]);
        }
        
        Arrays.sort(processes, (o1, o2) -> {
            return Integer.compare(o1.requestTime, o2.requestTime);
        });

        while (index < processes.length && processes[index].requestTime <= time) {
            pq.add(processes[index++]);
        }
        
        int count = 0;
        int answer = 0;
        while (count < processes.length) {
            while (index < processes.length && processes[index].requestTime <= time) {
                pq.add(processes[index++]);
            }
            if (pq.isEmpty()) {
                time = processes[index].requestTime;
                continue;
            }
            
            Process process = pq.poll();
            count++;
            time += process.processTime;
            
            answer += time - process.requestTime;
        }
        
        return answer / count;
    }
}