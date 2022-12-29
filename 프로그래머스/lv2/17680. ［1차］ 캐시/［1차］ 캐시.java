import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) {
            return cities.length * 5;
        }

        Queue<String> queue = new LinkedList<>();

        for (String str : cities) {
            String city = str.toLowerCase();
            if(queue.contains(city)) {
                answer += 1;
                queue.remove(city);
                queue.offer(city);
            } else {
                if(queue.size() < cacheSize) {
                    queue.offer(city);
                } else {
                    queue.poll();
                    queue.offer(city);
                }
                answer += 5;
            }
        }

        return answer;
    }
}