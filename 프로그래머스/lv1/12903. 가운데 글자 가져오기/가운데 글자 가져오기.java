import java.util.*;

class Solution {
    public String solution(String s) {
        int half_len = s.length() / 2;
        return (s.length() % 2 == 0) ? s.substring(half_len - 1, half_len + 1) : s.substring(half_len, half_len + 1);
    }
}