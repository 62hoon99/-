import java.util.*;

class Solution {
    public List<String> solution(String[] players, String[] callings) {
        
        Map<Integer, String> orderList = new HashMap<>();
        Map<String, Integer> nameList = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            orderList.put(i, players[i]);
            nameList.put(players[i], i);
        }
        
        for (String calling : callings) {
            // calling을 가지고 있는 nameList에서 order를 꺼냄
            // order - 1을 갖고 있는 name을 orderList에서 꺼냄
            // 위에서 꺼낸 name이 null이면 continue하고 null이 아니면 preName이 됨
            // preName의 nameList의 order를 +1, calling의 nameList의 order를 -1
            // orderList의 order value를 preName으로, order -1 value를 calling으로
            int order = nameList.get(calling);
            String preName = orderList.get(order - 1);
            if (preName == null) {
                continue;
            }
            nameList.put(preName, order);
            nameList.put(calling, order - 1);
            orderList.put(order, preName);
            orderList.put(order - 1, calling);
        }
        
        return new ArrayList<>(orderList.values());
    }
}