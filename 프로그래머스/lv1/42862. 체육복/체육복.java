import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        List<Integer> reserveList = new ArrayList<>();
        for (int r : reserve) {
            reserveList.add(r);
        }
        
        // cnt는 결국 옷 못받은 애들
        int cnt = 0;
        for (int l : lost) {
            if (reserveList.contains(l)) {
                reserveList.remove(Integer.valueOf(l));
                continue;
            }
            if (reserveList.contains(l - 1)) {
                reserveList.remove(Integer.valueOf(l - 1));
                continue;
            }
            if (reserveList.contains(l + 1)) {
                reserveList.remove(Integer.valueOf(l + 1));
                continue;
            }
            cnt++;
        }
        
        return n - cnt;
    }
}