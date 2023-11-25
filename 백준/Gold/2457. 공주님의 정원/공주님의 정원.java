

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final int YEAR = 2023;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Flower> flowers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            List<Integer> inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .boxed().collect(Collectors.toList());
            flowers.add(new Flower(inputs.get(0), inputs.get(1), inputs.get(2), inputs.get(3)));
        }

        br.close();

        LocalDate startAt = LocalDate.of(YEAR, 3, 1);
        LocalDate endAt = LocalDate.of(YEAR, 11, 30);

        // 대기
        Queue<Flower> flowerQueue = new PriorityQueue<>(flowers);

        Queue<ChoseFlower> subFlowers = new PriorityQueue<>(); // 후보군

        Stack<Flower> choseFlowers = new Stack<>(); // 뽑힌 애

        int answer = 0;

        while (!flowerQueue.isEmpty()) {
            Flower flower = flowerQueue.poll();

            if (!choseFlowers.isEmpty() && choseFlowers.peek().isAfterOrEqual(endAt)) {
                break;
            }

            // 처음
            if (choseFlowers.isEmpty() && flower.isBeforeOrEqual(startAt)) {
                subFlowers.add(new ChoseFlower(flower));
            } else if (!choseFlowers.isEmpty() && flower.isBeforeOrEqual(choseFlowers.peek().endAt)) {
                subFlowers.add(new ChoseFlower(flower));
            } else {
                if (subFlowers.isEmpty()) {
                    answer = -1;
                    break;
                }

                flowerQueue.add(flower);
                choseFlowers.push(subFlowers.poll());
                subFlowers.clear();
            }
        }

        if (answer == -1) {
            answer = 0;
        } else if (subFlowers.isEmpty()) {
            if (choseFlowers.peek().isAfterOrEqual(endAt)) {
                answer = choseFlowers.size();
            }
        } else {
            if (subFlowers.peek().isAfterOrEqual(endAt)) {
                answer = choseFlowers.size() + 1;
            }
        }

        System.out.println(answer);
    }

}

class Flower implements Comparable<Flower> {
    protected static final int YEAR = 2023;
    protected final LocalDate startAt;
    protected final LocalDate endAt;

    public Flower(LocalDate startAt, LocalDate endAt) {
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public Flower(int startMonth, int startDay, int endMonth, int endDay) {
        this(LocalDate.of(YEAR, startMonth, startDay), LocalDate.of(YEAR, endMonth, endDay));
    }

    @Override
    public String toString() {
        return "Flower{" +
                "startAt=" + startAt +
                ", endAt=" + endAt +
                '}';
    }

    @Override
    public int compareTo(Flower o) {
        return startAt.compareTo(o.startAt);
    }

    public boolean isBeforeOrEqual(LocalDate startAt) {
        return this.startAt.isBefore(startAt) || this.startAt.isEqual(startAt);
    }

    public boolean isAfterOrEqual(LocalDate endAt) {
        return this.endAt.isAfter(endAt);
    }
}

class ChoseFlower extends Flower {

    public ChoseFlower(LocalDate startAt, LocalDate endAt) {
        super(startAt, endAt);
    }

    public ChoseFlower(int startMonth, int startDay, int endMonth, int endDay) {
        super(startMonth, startDay, endMonth, endDay);
    }

    public ChoseFlower(Flower flower) {
        super(flower.startAt, flower.endAt);
    }

    @Override
    public int compareTo(Flower o) {
        return o.endAt.compareTo(endAt);
    }
}