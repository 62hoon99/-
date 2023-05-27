import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> reverseQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (String operation : operations) {
            String[] split = operation.split(" ");
            if (split[0].equals("I")) {
                reverseQueue.add(Integer.parseInt(split[1]));
                queue.add(Integer.parseInt(split[1]));
            }
            if (split[0].equals("D")) {
                if (split[1].equals("1")) {
                    Integer max = reverseQueue.poll();
                    if (max != null) {
                        queue.remove(max);
                    }
                }
                if (split[1].equals("-1")) {
                    Integer min = queue.poll();
                    if (min != null) {
                        reverseQueue.remove(min);
                    }
                }
            }
        }
        
        answer[0] = reverseQueue.peek() == null ? 0 : reverseQueue.poll();
        answer[1] = queue.peek() == null ? 0 : queue.poll();
        
        return answer;
    }
}