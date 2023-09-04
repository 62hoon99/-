import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        
        // msg를 char[] 로 바꾼다.
        // index를 움직이면서 다음과 같이 한다.
        // 1. char[index] 를 갖고 있으면 해당 index 를 tmp 에 넣는다.
        // 2. char[index] + char[index+1] 을 갖고 있으면 해당 index를 tmp에 넣는다.
        // 3. 갖고 있지 않으면 tmp를 answer에 추가하고 list에 char[index] + char[index+1]을 추가한다.
        
        char[] msgArr = msg.toCharArray();
        
        List<String> docs = new ArrayList<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            docs.add(String.valueOf((char) i ));
        }

        int index = 0;
        int tmp = 0;
        String str = "";
        while (index < msgArr.length) {
            str += msgArr[index] + "";
            if (docs.contains(str)) {
                tmp = docs.indexOf(str);
                index++;
                // System.out.println("contain : " + str);
            } else {
                // System.out.println("not contain : " + str);
                answer.add(tmp + 1);
                tmp = 0;
                docs.add(str);
                str = "";
            }
        }
        if (!str.isEmpty()) {
            answer.add(tmp + 1);
        }
        
        return answer;
    }
}