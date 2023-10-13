import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < maps.length; i++) {
            for (int k = 0; k < maps[i].length(); k++) {
                if (maps[i].charAt(k) != 'X') {
                    list.add(find(maps, k, i));
                }
            }
        }
        Collections.sort(list);
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer.length == 0 ? new int[]{-1} : answer;
    }
    
    private int find(String[] maps, int x, int y) {
        int days = Character.getNumericValue(maps[y].charAt(x));
        
        maps[y] = maps[y].substring(0, x) + 'X' + maps[y].substring(x + 1);
        
        // 왼쪽
        if (x > 0 && maps[y].charAt(x - 1) != 'X') {
            days += find(maps, x - 1, y);
        }
        
        // 오른쪽
        if (x + 1 < maps[0].length() && maps[y].charAt(x + 1) != 'X') {
            days += find(maps, x + 1, y);
        }
        
        // 위쪽
        if (y > 0 && maps[y - 1].charAt(x) != 'X') {
            days += find(maps, x, y - 1);
        }
        
        // 아래쪽
        if (y + 1 < maps.length && maps[y + 1].charAt(x) != 'X') {
            days += find(maps, x, y + 1);
        }
        
        return days;
    }
}