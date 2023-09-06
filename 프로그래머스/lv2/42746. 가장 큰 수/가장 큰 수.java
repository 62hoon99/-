import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        List<Number> numberList = new ArrayList<>();
        
        for (int num : numbers) {
            numberList.add(new Number(Integer.toString(num)));
        }
        Collections.sort(numberList);
        
        for (Number number : numberList) {
            answer.append(number.number);
        }
        
        return answer.toString().startsWith("0") ? "0" : answer.toString();
    }
    
    static class Number implements Comparable<Number> {
        private String number;
        
        public Number(String number) {
            this.number = number;
        }
        
        public int compareTo(Number o) {
            long a = Long.parseLong(number + o.number);
            long b = Long.parseLong(o.number + number);
            
            if (a > b) {
                return -1;
            }
            if (a == b) {
                return 0;
            }
            
            return 1;
        }
    }
}