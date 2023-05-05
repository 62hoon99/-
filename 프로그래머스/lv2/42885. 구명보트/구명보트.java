import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int front = 0;
        int back = people.length - 1;
        
        Arrays.sort(people);
        
        while (front <= back) {
            if (people[front] + people[back] <= limit) {
                answer++;
                front++;
                back--;
            } else {
                answer++;
                back--;
            }
        }
        
        return answer;
    }
}