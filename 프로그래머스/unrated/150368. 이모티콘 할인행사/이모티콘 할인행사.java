import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    private static final int[] discountArray = {10, 20, 30, 40};

    public int[] solution(int[][] usersArray, int[] emoticons) {

        List<User> users = Arrays.stream(usersArray).map(u -> new User(u[0], u[1])).collect(Collectors.toList());

        return find(emoticons, users, 0);
    }

    private int[] find(int[] emoticons, List<User> users, int depth) {
        if (emoticons.length == depth) {
            int lastCount = (int) users.stream().filter(User::isEmoticonPlusServiceAvailable).count();
            int lastMoney = users.stream().filter(user -> !user.isEmoticonPlusServiceAvailable())
                    .mapToInt(User::getPurchaseAmount).sum();

            return new int[]{lastCount, lastMoney};
        }

        int[] maxResult = new int[2];

        for (int discount : discountArray) {
            users.forEach(user -> user.buy(emoticons[depth], discount));

            int[] result = find(emoticons, users, depth + 1);
            if ((maxResult[0] == result[0] && maxResult[1] < result[1]) || (maxResult[0] < result[0])) {
                maxResult = result;
            }

            users.forEach(user -> user.sell(emoticons[depth], discount));
        }

        return maxResult;
    }

    private static class User {
        private final int ratio;
        private final int limit;
        private int purchaseAmount;

        public User(int ratio, int limit) {
            this.ratio = ratio;
            this.limit = limit;
        }

        public int getPurchaseAmount() {
            return purchaseAmount;
        }

        public boolean isEmoticonPlusServiceAvailable() {
            return purchaseAmount >= limit;
        }

        public void buy(int amount, int ratio) {
            if (this.ratio <= ratio) {
                purchaseAmount += calculateDiscountedAmount(amount, ratio);
            }
        }

        public void sell(int amount, int ratio) {
            if (this.ratio <= ratio) {
                purchaseAmount -= calculateDiscountedAmount(amount, ratio);
            }
        }

        private int calculateDiscountedAmount(int amount, int ratio) {
            return amount * (100 - ratio) / 100;
        }
    }
}