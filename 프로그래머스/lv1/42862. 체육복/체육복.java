import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Arrays.sort(lost);
        
        List<Integer> reserveList = new ArrayList<>();
        List<Integer> lostList = new ArrayList<>();
        for (int r : reserve) {
            reserveList.add(r);
        }
        for (int l : lost) {
            lostList.add(l);
        }
        
        List<Integer> solo = new ArrayList<>();
        for (int l : lostList) {
            if (reserveList.contains(l)) {
                solo.add(l);
            }
        }
        reserveList.removeAll(solo);
        lostList.removeAll(solo);
        
        // cnt는 결국 옷 못받은 애들
        int cnt = 0;
        for (int l : lostList) {
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