import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        int[] supoja = new int[3];
        
        for(int i=0; i<answers.length; i++) {
            //1번 수포자
            if(i % 5 == answers[i] - 1) supoja[0]++;
            
            //2번 수포자
            if((i % 8) % 2 == 0) {
                if(answers[i] == 2) supoja[1]++;
            } else {
                if(i%8 == 1 && answers[i] == 1) supoja[1]++;
                if(i%8 == 3 && answers[i] == 3) supoja[1]++;
                if(i%8 == 5 && answers[i] == 4) supoja[1]++;
                if(i%8 == 7 && answers[i] == 5) supoja[1]++;
            }
            
            //3번 수포자
            if((i%10 == 0 || i%10 == 1) && answers[i] == 3) supoja[2]++;
            if((i%10 == 2 || i%10 == 3) && answers[i] == 1) supoja[2]++;
            if((i%10 == 4 || i%10 == 5) && answers[i] == 2) supoja[2]++;
            if((i%10 == 6 || i%10 == 7) && answers[i] == 4) supoja[2]++;
            if((i%10 == 8 || i%10 == 9) && answers[i] == 5) supoja[2]++;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        int max = Math.max(Math.max(supoja[0], supoja[1]), supoja[2]);
        
        for(int i=0 ;i<supoja.length; i++){
            if(max == supoja[i]) list.add(i+1);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}