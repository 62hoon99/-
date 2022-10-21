class Solution {
    public String solution(int a, int b) {
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int date = b;
        for(int i=0; i<a-1; i++) {
            date += month[i];
        }
        int day = date % 7;
        String answer = "";
        
        switch(day) {
            case 0: answer = "THU";
                break;
            case 1: answer = "FRI";
                break;
            case 2: answer = "SAT";
                break;
            case 3: answer = "SUN";
                break;
            case 4: answer = "MON";
                break;
            case 5: answer = "TUE";
                break;
            case 6: answer = "WED";
        }
        
        return answer;
    }
}