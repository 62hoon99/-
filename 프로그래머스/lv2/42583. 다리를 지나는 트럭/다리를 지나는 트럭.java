import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Bridge bridge = new Bridge(weight, bridge_length);
        
        int idx = 0;
        for (int i = 0; i < 100_000_002; i++) {
            bridge.outTruck(i);
            if (idx == truck_weights.length && bridge.isTrucksEmpty()) {
                answer = i;
                break;
            }
            
            if (idx < truck_weights.length && bridge.addTruck(truck_weights[idx], i)) {
                idx++;
            }
        }
        
        return answer + 1;
    }
    
    static class Bridge {
        private Trucks trucks = new Trucks();
        private int weight;
        private int length;
        
        public Bridge(int weight, int length) {
            this.weight = weight;
            this.length = length;
        }
        
        public boolean addTruck(int truckWeight, int time) {
            if (trucks.isAbleToAdd(weight, truckWeight)) {
                trucks.add(new Truck(truckWeight, time + length, time));
                return true;
            }
            return false;
        }
        
        public void outTruck(int time) {
            trucks.out(time);
        }
        
        public boolean isTrucksEmpty() {
            return trucks.isEmpty();
        }
    }
    
    static class Trucks {
        private Queue<Truck> trucks = new LinkedList<>();
        private int totalWeight = 0;
        
        public void add(Truck truck) {
            trucks.add(truck);
            totalWeight += truck.getWeight();
        }
        
        public boolean isAbleToAdd(int bridgeWeight, int truckWeight) {
            return bridgeWeight >= truckWeight + totalWeight;
        }
        
        public void out(int time) {
            if (!trucks.isEmpty()) {
                Truck firstTruck = trucks.peek();
                if (firstTruck.sameOutTime(time)) {
                    trucks.poll();
                    totalWeight -= firstTruck.getWeight();
                }
            }
        }
        
        public boolean isEmpty() {
            return trucks.isEmpty();
        }
    }
    
    static class Truck {
        private int weight;
        private int outTime;
        private int inTime;
        
        public Truck(int weight, int outTime, int inTime) {
            this.weight = weight;
            this.outTime = outTime;
            this.inTime = inTime;
        }
        
        public boolean sameOutTime(int time) {
            return outTime == time;
        }
        
        public void plusOutTime(int time) {
            outTime += time;
        }
        
        public int getWeight() {
            return this.weight;
        }
    }
}