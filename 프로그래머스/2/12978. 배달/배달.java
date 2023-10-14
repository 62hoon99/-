import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<Town> towns = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            towns.add(new Town(i));
        }
        
        for (int[] r : road) {
            Road nRoad = new Road(r[2], towns.get(r[0] - 1), towns.get(r[1] - 1));
            towns.get(r[0] - 1).addRoad(nRoad);
            towns.get(r[1] - 1).addRoad(nRoad);
        }
        
        towns.get(0).find(0, K);
        
        for (Town town : towns) {
            if (town.minTime <= K) {
                answer++;
            }
        }

        return answer;
    }
    
    private static class Town {
        private final int id;
        private final List<Road> roads = new ArrayList<>();
        private int minTime = Integer.MAX_VALUE;
        
        public Town(int id) {
            this.id = id;
        }
        
        public void addRoad(Road road) {
            roads.add(road);
        }
        
        public void find(int totalTime, int k) {
            minTime = totalTime;
            
            for (Road road : roads) {
                if (totalTime + road.time > k) {
                    continue;
                }
                Town otherTown = road.getOtherTown(this);
                
                if (otherTown.minTime > totalTime + road.time) {
                    otherTown.find(totalTime + road.time, k);   
                }
            }
        }
    }
    
    private static class Road {
        private final int time;
        private final Town town1;
        private final Town town2;
        
        public Road(int time, Town town1, Town town2) {
            this.time = time;
            this.town2 = town2;
            this.town1 = town1;
        }
        
        public Town getOtherTown(Town town) {
            if (town1.equals(town)) {
                return town2;
            }
            return town1;
        }
    }
}