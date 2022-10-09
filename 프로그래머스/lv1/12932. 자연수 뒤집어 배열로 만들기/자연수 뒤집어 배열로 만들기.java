import java.util.*;

class Solution {
    public int[] solution(long n) {

        StringBuilder sb = new StringBuilder(Long.toString(n));
        String[] stArr = sb.reverse().toString().split("");
        return Arrays.stream(stArr).mapToInt(Integer::parseInt).toArray();
    }
}