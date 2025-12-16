import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        
        for(int i = 0; i < operations.length; i++) {
            String[] s = operations[i].split(" ");
         
            if(s[0].equals("D") && maxQueue.isEmpty()) {
                continue;
            }
            if(s[0].equals("I")) {
                maxQueue.offer(Integer.parseInt(s[1]));
                minQueue.offer(Integer.parseInt(s[1]));
            }
            else if(s[0].equals("D") && s[1].equals("1")) {
                int max = maxQueue.poll();
                minQueue.remove(max);
            } else {
                int min = minQueue.poll();
                maxQueue.remove(min);
            }
        }

        if(maxQueue.isEmpty()) return new int[] {0,0};
        else return new int[] {maxQueue.poll(), minQueue.poll()};
    }
}