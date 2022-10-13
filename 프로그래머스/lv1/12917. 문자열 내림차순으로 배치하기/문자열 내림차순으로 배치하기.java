import java.util.*;
class Solution {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuffer sb = new StringBuffer(new String(chars));
        return sb.reverse().toString();
    }
}