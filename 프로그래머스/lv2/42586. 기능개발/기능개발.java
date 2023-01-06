import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        // linked큐를 사용해서 다 넣은 다음에 각 speeds를 더해준다.
        // 제일 앞에 있는 애가 100이면 99이하의 수가 나올 때 까지 반복문을 돌린다.

        List<Work> works = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++) {
            works.add(new Work(progresses[i], speeds[i]));
        }

        Queue<Work> queue = new LinkedList<>();
        for (Work work : works) {
            queue.add(work);
        }

        List<Integer> answerList = new ArrayList<>();

        do {
            for(int i = 0; i < queue.size(); i++) {
                Work poll = queue.poll();
                poll.addProgress();
                queue.add(poll);
            }

            int cnt = 0;
            while(!queue.isEmpty()) {
                if (queue.peek().progress >= 100) {
                    queue.poll();
                    cnt++;
                } else {
                    break;
                }
            }

            if(cnt > 0) {
                answerList.add(cnt);
            }
        } while(!queue.isEmpty());

        return answerList.stream().mapToInt(i -> i).toArray();
    }

    static class Work {
        public Work(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

        int progress;
        int speed;

        private void addProgress() {
            progress += speed;
        }
    }
}