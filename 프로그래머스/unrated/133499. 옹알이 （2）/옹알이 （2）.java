import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String str : babbling) {
            char[] arr = str.toCharArray();
            boolean flag = true;
            char tmp = ' ';
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == 'a') {
                    if(i+2 < arr.length && arr[i+1] == 'y' && arr[i+2] == 'a' && tmp != 'a') {
                        tmp = 'a';
                        i = i+2;
                    } else {
                        flag = false;
                        break;
                    }
                } else if(arr[i] == 'y') {
                    if(i+1 < arr.length && arr[i+1] == 'e' && tmp != 'y') {
                        tmp = 'y';
                        i = i+1;
                    } else {
                        flag = false;
                        break;
                    }
                }else if(arr[i] == 'w') {
                    if(i+2 < arr.length && arr[i+1] == 'o' && arr[i+2] == 'o' && tmp != 'w') {
                        tmp = 'w';
                        i = i+2;
                    } else {
                        flag = false;
                        break;
                    }
                }else if(arr[i] == 'm') {
                    if(i+1 < arr.length && arr[i+1] == 'a' && tmp != 'm') {
                        tmp = 'm';
                        i = i+1;
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                System.out.println(str);
                answer++;
            }
        }
        return answer;
    }
}