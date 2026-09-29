import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int currentWeight = 0;
        int index = 0;
        Queue<Truck> trucks = new LinkedList<>();
        while (index < truck_weights.length || !trucks.isEmpty()) {
            time++;
            if (!trucks.isEmpty() && time - trucks.peek().time == bridge_length) {
                Truck truck = trucks.poll();
                currentWeight -= truck.weight;
            }
            
            if (index < truck_weights.length
                && trucks.size() < bridge_length 
                && currentWeight + truck_weights[index] <= weight) {
                trucks.add(new Truck(time, truck_weights[index]));
                currentWeight += truck_weights[index++];
            }
        }
        
        return time;
    }
    
    public class Truck {
        int time;
        int weight;
        
        public Truck(int time, int weight) {
            this.time = time;
            this.weight = weight;
        }
    }
}