import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
//         StringBuilder[] sb = new StringBuilder[n];
//         String[] answer = new String[n];
//         int sum_num = 0;
//         System.out.println(ten_two(arr1[0]) + ten_two(arr2[0]));
//         for(int i=0; i<n ;i++) {
//             sb[i] = new StringBuilder();
//             answer[i] = new String();
//             sum_num = ten_two(arr1[i]) + ten_two(arr2[i]);
//             while(sum_num > 0) {
//                 if(sum_num % 10 > 0) sb[i].append("#");
//                 else sb[i].append(" ");
//                 sum_num /= 10;
//             }
//             for(int k=0; k<n-sb[i].length(); k++){
//                 sb[i].append(" ");
//             }
//             answer[i] = sb[i].reverse().toString();
//         }
        
//         return answer;
        
        char[][] chars = new char[n][n];
        String[] answer = new String[n];
        Long num = 0L;
        for(int i=0; i<n; i++) {
            Arrays.fill(chars[i], ' ');
            num = ten_two(arr1[i]) + ten_two(arr2[i]);
            int count = n - 1;
            while(num > 0){
                if(num % 10 > 0) chars[i][count] = '#';
                count--;
                num /= 10;
            }
            answer[i] = new String(chars[i]);
        }
        return answer;
    }
    
    public static Long ten_two(int num) {
        if(num == 0) return 0L;
        
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            sb.append(Integer.toString(num % 2));
            num /= 2;
        }
        return Long.parseLong(sb.reverse().toString());
    }
}