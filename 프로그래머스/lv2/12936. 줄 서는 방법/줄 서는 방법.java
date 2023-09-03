import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            arr.add(i);
        }
        int cnt=1;
        long temp=k;

        while(cnt<=n){
            long tempQuotient=temp/factorial(n-cnt);
            long tempRemainder=temp%factorial(n-cnt);
            if(tempRemainder!=0){
                answer[cnt-1]=arr.get(Long.valueOf(tempQuotient).intValue()+1);
                arr.remove(Long.valueOf(tempQuotient).intValue()+1);
                temp=tempRemainder;
            } else{
                answer[cnt-1]=arr.get(Long.valueOf(tempQuotient).intValue());
                arr.remove(Long.valueOf(tempQuotient).intValue());
                for(int i=1;i<arr.size();i++){
                    answer[cnt-1+i]=arr.get(arr.size()-i);
                }
                break;
            }

            cnt++;
        }

        return answer;
    }

    static long factorial(int n){
        if(n==1||n==0){
            return 1;
        }
        return n*factorial(n-1);
    }
}