class Solution {
    public int solution(String dartResult) {
        int score = 0;
        
        char[] chars = dartResult.toCharArray();
        int[] totalscore = new int[3];
        int index = 0;
        
        for(int i=0; i<chars.length; i++) {
            if(Character.isDigit(chars[i])) {
                score = score * 10 + (chars[i] - '0');
            } else {
                if(chars[i] == 'S') {
                    totalscore[index++] = score;
                    score = 0;
                } else if(chars[i] == 'D') {
                    totalscore[index++] = (int)Math.pow(score, 2);
                    score = 0;
                } else if(chars[i] == 'T') {
                    totalscore[index++] = (int)Math.pow(score, 3);
                    score = 0;
                } else if(chars[i] == '*') {
                    if(index == 1) totalscore[index - 1] *= 2;
                    else {
                        totalscore[index - 2] *= 2;
                        totalscore[index - 1] *= 2;
                    }
                } else if(chars[i] == '#') {
                    totalscore[index - 1] *= -1;
                }
            }
        }
        
        return totalscore[0] + totalscore[1] + totalscore[2];
    }
}