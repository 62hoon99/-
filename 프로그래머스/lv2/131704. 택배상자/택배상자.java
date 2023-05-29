import java.util.*;

class Solution {
    public int solution(int[] orders) {
        int answer = 0;
        
        // 현재 order 순서와 맞지 않다면 나올 때까지 앞에 있는 것들을 stack에 넣는다.
        // 나오면 result를 ++한다.
        // 다음 order를 확인하는데 stack의 제일 앞에 있는 것과 같으면 stack을 pop한다.
            // stack의 제일 앞과 같지 않다면 order 값과 같을 때 까지 stack에 넣는다.
        
        Stack<Integer> stack = new Stack<>();
        int box = 1;
        for (int order : orders) {
            if (!stack.isEmpty() && !stack.peek().equals(order) && box > order) {
                break;
            }
            
            if (!stack.isEmpty() && stack.peek().equals(order)) {
                stack.pop();
                answer++;
                continue;
            }
            
            while (order != box) {
                stack.add(box++);
                if (box == orders.length + 1) {
                    break;
                }
            }
            
            if (order == box) {
                answer++;
                box++;
            }
        }
        
        return answer;
    }
}