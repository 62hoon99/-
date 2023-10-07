

import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final int[] discountArray = {10, 20, 30 ,40};

    public int[] solution(int[][] usersArray, int[] emoticons) {

        for (int[] userArray : usersArray) {
            users.add(new User(userArray[0], userArray[1]));
        }

        find(emoticons, 0);

        int[] answer = new int[2];
        answer[0] = countAnswer;
        answer[1] = moneyAnswer;
        return answer;
    }

    private int countAnswer = 0;
    private int moneyAnswer = 0;
    private final List<User> users = new ArrayList<>();

    private void find(int[] emoticons, int depth) {
        if (emoticons.length == depth) {
            int lastCount = 0;
            int lastMoney = 0;

            for (User user : users) {
                if (user.isBuyService()) {
                    lastCount++;
                } else {
                    lastMoney += user.buyMoney;
                }
            }

            if (countAnswer == lastCount && moneyAnswer < lastMoney) {
                moneyAnswer = lastMoney;
            } else if (countAnswer < lastCount) {
                countAnswer = lastCount;
                moneyAnswer = lastMoney;
            }
            return;
        }

        for (int discount : discountArray) {
            users.forEach(user -> user.buy(emoticons[depth], discount));
            find(emoticons, depth + 1);
            users.forEach(user -> user.sell(emoticons[depth], discount));
        }
    }

    private class User {
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

        public void buy(int money, int discount) {
            if (this.discount <= discount) {
                buyMoney += money * (100 - discount) / 100;
            }
        }

        public void sell(int money, int discount) {
            if (this.discount <= discount) {
                buyMoney -= money * (100 - discount) / 100;
            }
        }

    }
}