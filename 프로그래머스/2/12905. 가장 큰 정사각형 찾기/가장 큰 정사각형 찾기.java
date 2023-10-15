import java.util.*;
import java.math.*;

class Solution
{
    public int solution(int [][]board)
    {
        int len = 0;

        for (int i = 1; i < board.length; i++) {
            for (int k = 1; k < board[i].length; k++) {                
                if (board[i][k] == 1) {
                    board[i][k] = Math.min(Math.min(board[i - 1][k - 1], board[i][k - 1]), board[i - 1][k]) + 1;
                }
                
                if (len < board[i][k]) {
                    len = board[i][k];
                }
            }
        }
        
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 1 && len == 0) {
                len = 1;
                break;
            }
        }
        
        return len * len;
    }
}