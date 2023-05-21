import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        List<Car> cars = new ArrayList<>();
        for (int[] route : routes) {
            cars.add(new Car(route[0], route[1]));
        }
        Collections.sort(cars);
        
        Queue<Car> queue = new LinkedList<>();
        int idx = 0;
        while(true) {
            if (idx == cars.size()) {
                break;
            }
            
            if (!queue.isEmpty()) {
                Car car = queue.peek();
                if (car.isLessThanIn(cars.get(idx))) {
                    queue.clear();
                    answer++;
                } else if (cars.get(idx).isBiggerThanIn(car)) {
                    queue.add(cars.get(idx++));
                }
            } else {
                queue.add(cars.get(idx++));
            }
        }
        
        return queue.isEmpty() ? answer : answer + 1;
    }
    
    static class Car implements Comparable<Car> {
        private int in;
        private int out;
        
        public Car(int in, int out) {
            this.in = in;
            this.out = out;
        }
        
        public boolean isSameOut(int out) {
            return this.out == out;
        }
        
        public boolean isLessThanIn(Car o) {
            return this.out < o.in;
        }
        
        public boolean isBiggerThanIn(Car o) {
            return this.in <= o.out;
        }
        
        public int compareTo(Car o) {
            return this.out - o.out;
        }
        
        public String toString() {
            return in + " " + out;
        }
    }
}