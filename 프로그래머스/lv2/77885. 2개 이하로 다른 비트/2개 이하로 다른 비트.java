import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int index = 0;
        
        for (long number : numbers) {
            if (number % 2 == 0) {
                answer[index++] = number + 1;
                continue;
            }
            String bin = Long.toBinaryString(number);
            if (bin.replaceAll("1", "").isEmpty()) {
                bin = "10" + bin.replaceFirst("1", "");
            } else {
                for (int i = bin.length() - 1; i >= 0; i--) {
                    if (bin.charAt(i) == '0') {
                        bin = bin.substring(0, i) + "10" + bin.substring(i + 2, bin.length());
                        break;
                    }
                }
            }
            // System.out.println(bin);
            answer[index++] = Long.parseLong(bin, 2);
        }
        
        return answer;
    }
}
