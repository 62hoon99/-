import java.util.*;

class Solution {
    public int[] solution(int[][] usersArray, int[] emoticons) {
        
        // 목표: 1.임티 플러스 서비스 가입자 상승 2.이모티콘 판매액
        // n 명의 카톡 유저에게 임티 m개 판다.
        
        // 구매 비용의 합이 일정 가격 이상이 된다면, 구취 후 서비스 가입
        
        // 가능한 할인율 10%, 20%, 30%, 40%
        
        for (int[] userArray : usersArray) {
            users.add(new User(userArray[0], userArray[1]));
        }
        
        int[] discountArray = {10, 20, 30 ,40};
        for (int discount : discountArray) {
            List<User> discountUsers = new ArrayList<>();
            for (User user : users) {
                if (discount >= user.discount) {
                    discountUsers.add(user);
                }
            }
            map.put(discount, discountUsers);
            //System.out.println(discount + " " + discountUsers.size());
        }
        
        find(emoticons, 0);
        
        int[] answer = new int[2];
        answer[0] = countAnswer;
        answer[1] = moneyAnswer;
        return answer;
    }
    
    private Map<Integer,List<User>> map = new HashMap<>();
    private int countAnswer = 0;
    private int moneyAnswer = 0;
    private List<User> users = new ArrayList<>();
    
    private void find(int[] emoticons, int depth) {
        if (emoticons.length == depth) {
            int lastCount = 0;
            int lastMoney = 0;
            
            for (User user : users) {
                // System.out.println(user);
                if (user.isBuyService()) {
                    lastCount++;
                } else {
                    lastMoney += user.buyMoney;
                }
            }
            // System.out.println(lastCount + " " + lastMoney);
            
            if (countAnswer == lastCount && moneyAnswer < lastMoney) {
                countAnswer = lastCount;
                moneyAnswer = lastMoney;
            } else if (countAnswer < lastCount) {
                countAnswer = lastCount;
                moneyAnswer = lastMoney;
            }
            return;
        }
        
        int[] discountArray = {10, 20, 30 ,40};
        for (int discount : discountArray) {
            int discountEmoticon = emoticons[depth] * (100 - discount) / 100;
            map.get(discount).stream().forEach(user -> user.buy(discountEmoticon));
            find(emoticons, depth + 1);
            map.get(discount).stream().forEach(user -> user.sell(discountEmoticon));
        }
    }
    
    private static class User {
        private int discount;
        private int moneyLine;
        
        private int buyMoney = 0;
        
        public User(int discount, int moneyLine) {
            this.discount = discount;
            this.moneyLine = moneyLine;
        }
        
        public boolean isBuyService() {
            return buyMoney >= moneyLine;
        }
        
        public void buy(int money) {
            buyMoney += money;
        }
        
        public void sell(int money) {
            buyMoney -= money;
        }
        
        public String toString() {
            return "discount: " + discount + " moneyLine: " + moneyLine + " buyMoney: " + buyMoney;
        }
    }
}