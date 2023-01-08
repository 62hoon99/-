import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for(int i = 0; i < board.length; i++) {
                int value = board[i][move - 1];
                if(value > 0) {
                    board[i][move - 1] = 0;
                    if(stack.isEmpty()) {
                        stack.push(value);
                    } else {
                        if(stack.peek().equals(value)) {
                            stack.pop();
                            answer += 2;
                        } else {
                            stack.push(value);
                        }
                    }
                    break;
                }
            }
        }
        
        return answer;
    }
}