import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";

        List<Integer> foodList = new ArrayList<>();

        for(int i=0; i<food.length; i++) {
            food[i] = food[i]/2;
        }

        for(int i=1; i<food.length; i++) {
            for(int k=0; k<food[i]; k++) {
                foodList.add(i);
            }
        }
        
        foodList.add(0);

        for(int i=foodList.size()-2; i>=0; i--) {
            foodList.add(foodList.get(i));
        }

        for (Integer integer : foodList) {
            answer += integer;
        }

        return answer;
    }
}