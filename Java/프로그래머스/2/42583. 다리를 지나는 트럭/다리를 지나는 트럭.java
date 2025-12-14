import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> queue = new LinkedList<>();
        int index = 0;
        int currentTime = 1;
        int currentWeight = 0;
        
        queue.add(new int[]{currentTime, truck_weights[index]});
        currentWeight += truck_weights[index];
        index++;
        while (!queue.isEmpty()) {
            currentTime++;
            if (!queue.isEmpty() && currentTime - queue.peek()[0] == bridge_length) {
                currentWeight -= queue.poll()[1];
            }
            
            if (index < truck_weights.length 
                    && bridge_length > queue.size() 
                    && currentWeight + truck_weights[index] <= weight) {
                queue.add(new int[]{currentTime, truck_weights[index]});
                currentWeight += truck_weights[index];
                index++;
            }
        }
        
        return currentTime;
    }
}