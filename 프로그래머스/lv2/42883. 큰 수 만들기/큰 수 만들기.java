import java.util.*;

class Solution {
    public String solution(String number, int t) {
        StringBuilder answer = new StringBuilder();
        
        String str = number;
        
        // z는 number.length() - k
        // number의 앞에서 부터 뒤로 z번 이동하면서 제일 큰 거 선택
        // 큰 수 제거하고, z - 1
        // number의 앞에서 부터 뒤로 z - 1번 이동하면서 제일 큰거 선택
        // ...
        
//         List<Integer> list = new ArrayList<>();
//         for (String n : number.split("")) {
//             list.add(Integer.parseInt(n));
//         }
        
//         int z = number.length() - k;
//         while (z > 0) {
//             int max = 0;
//             for (int i = 0; i < list.size() - z + 1; i++) {
//                 max = Math.max(list.get(i), max);
//             }
//             answer.append(Integer.toString(max));
//             list.remove(new Integer(max));
//             z--;
//         }
        
        for (int i = 0; i < number.length() - t; i++) {
            int max = 0;
            int idx = 0;
            for (int k = 0; k < str.length() - (number.length() - t) + answer.length() + 1; k++) {
                if (max < Character.getNumericValue(str.charAt(k))) {
                    max = Math.max(Character.getNumericValue(str.charAt(k)), max);
                    idx = k;
                }
                if (max == 9) {
                    break;
                }
            }
            str = str.substring(idx + 1);
            answer.append(max);
        }
        
        return answer.toString();
    }
}