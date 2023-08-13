import java.util.*;

class Solution {
    public int solution(int[] toppings) {
        int answer = 0;
        
        Person old = new Person();
        Person yg = new Person();
        
        for (int topping : toppings) {
            yg.addDesert(topping);
        }
        
        for (int topping : toppings) {
            old.addDesert(topping);
            yg.removeDesert(topping);
            if (old.getCount() == yg.getCount()) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static class Person {
        private Map<Integer, Integer> dessertMap;
        private int count;
        
        public Person() {
            dessertMap = new HashMap<>();
            count = 0;
        }
        
        public void addDesert(int dessert) {
            dessertMap.put(dessert, dessertMap.getOrDefault(dessert, 0) + 1);
            if (dessertMap.get(dessert) == 1) {
                count++;
            }
        }
        
        public void removeDesert(int dessert) {
            dessertMap.put(dessert, dessertMap.getOrDefault(dessert, 0) - 1);
            if (dessertMap.get(dessert) == 0) {
                count--;
            }
        }
        
        public int getCount() {
            return count;
        }
    }
}