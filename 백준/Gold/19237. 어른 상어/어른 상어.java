

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

enum Direction {
    UP, DOWN, LEFT, RIGHT; // 1, 2, 3, 4

    public static Direction getDirection(int num) {
        if (num == 1) {
            return UP;
        }
        if (num == 2) {
            return DOWN;
        }
        if (num == 3) {
            return LEFT;
        }
        return RIGHT;
    }
}

class Shark {
    private int id;
    private Direction direction;
    private Map<Direction, List<Direction>> directionListMap = new HashMap<>();
    private int x;
    private int y;

    public Shark(int id, Direction direction) {
        this.id = id;
        this.direction = direction;
    }

    public void addDirections(Direction direction, List<Direction> directions) {
        directionListMap.put(direction, directions);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Direction> getDirectionList() {
        return directionListMap.get(direction);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isEqualPosition(Shark o) {
        return this.x == o.x && this.y == o.y;
    }

    public int getId() {
        return id;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]); // 칸 N*N
        int M = Integer.parseInt(str[1]); // 상어 개수
        int K = Integer.parseInt(str[2]); // K 번 이후에는 냄새가 사라짐

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int k = 0; k < input.length; k++) {
                arr[i][k] = Integer.parseInt(input[k]);
            }
        }

        String[] input = br.readLine().split(" ");

        List<Shark> sharks = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            sharks.add(new Shark(i, Direction.getDirection(Integer.parseInt(input[i - 1]))));
        }

        for (Shark shark : sharks) {
            for (int k = 0; k < 4; k++) {
                String[] inputs = br.readLine().split(" ");
                Direction direction = Direction.getDirection(k + 1);
                List<Direction> directions = Arrays.stream(inputs).mapToInt(Integer::parseInt)
                        .mapToObj(Direction::getDirection).collect(Collectors.toList());
                shark.addDirections(direction, directions);
            }
        }

        int[][] smell = new int[N][N];
        int[][] mark = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (arr[i][k] > 0) {
                    smell[i][k] = K + 1;
                    Shark shark = sharks.get(arr[i][k] - 1);
                    shark.setX(k);
                    shark.setY(i);
                    mark[i][k] = shark.getId();
                }
            }
        }

        int answer = 0;

        while (sharks.size() > 1) {
            answer++;
            if (answer == 1001) {
                break;
            }

            for (int i = 0; i < N; i++) {
                for (int k = 0; k < N; k++) {
                    if (smell[i][k] > 0) {
                        smell[i][k]--;
                    }
                    if (smell[i][k] == 0) {
                        mark[i][k] = 0;
                    }
                }
            }

            for (Shark shark : sharks) {
                int x = shark.getX();
                int y = shark.getY();

                List<Direction> directions = shark.getDirectionList();
                for (Direction direction : directions) {
                    if (Direction.UP.equals(direction)) {
                        if (y > 0 && smell[y - 1][x] == 0) {
                            shark.setY(y - 1);
                            shark.setDirection(Direction.UP);
                            break;
                        }
                    }
                    if (Direction.DOWN.equals(direction)) {
                        if (y < N - 1 && smell[y + 1][x] == 0) {
                            shark.setY(y + 1);
                            shark.setDirection(Direction.DOWN);
                            break;
                        }
                    }
                    if (Direction.RIGHT.equals(direction)) {
                        if (x < N - 1 && smell[y][x + 1] == 0) {
                            shark.setX(x + 1);
                            shark.setDirection(Direction.RIGHT);
                            break;
                        }
                    }
                    if (Direction.LEFT.equals(direction)) {
                        if (x > 0 && smell[y][x - 1] == 0) {
                            shark.setX(x - 1);
                            shark.setDirection(Direction.LEFT);
                            break;
                        }
                    }
                    if (directions.get(directions.size() - 1).equals(direction)) {
                        for (Direction d : directions) {
                            if (Direction.UP.equals(d)) {
                                if (y > 0 && mark[y - 1][x] == shark.getId()) {
                                    shark.setY(y - 1);
                                    shark.setDirection(Direction.UP);
                                    break;
                                }
                            }
                            if (Direction.DOWN.equals(d)) {
                                if (y < N - 1 && mark[y + 1][x] == shark.getId()) {
                                    shark.setY(y + 1);
                                    shark.setDirection(Direction.DOWN);
                                    break;
                                }
                            }
                            if (Direction.RIGHT.equals(d)) {
                                if (x < N - 1 && mark[y][x + 1] == shark.getId()) {
                                    shark.setX(x + 1);
                                    shark.setDirection(Direction.RIGHT);
                                    break;
                                }
                            }
                            if (Direction.LEFT.equals(d)) {
                                if (x > 0 && mark[y][x - 1] == shark.getId()) {
                                    shark.setX(x - 1);
                                    shark.setDirection(Direction.LEFT);
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            Set<Shark> deadSharks = new HashSet<>();

            for (int i = 0; i < sharks.size(); i++) {
                for (int k = i + 1; k < sharks.size(); k++) {
                    Shark bigShark = sharks.get(i);
                    Shark smallShark = sharks.get(k);
                    if (bigShark.isEqualPosition(smallShark)) {
                        deadSharks.add(smallShark);
                    }
                }
            }

            sharks.removeAll(deadSharks);

            for (Shark shark : sharks) {
                smell[shark.getY()][shark.getX()] = K + 1;
                mark[shark.getY()][shark.getX()] = shark.getId();
            }
        }

        // 냄새 분자들의 지속 시간을 -1 한다

        // 상어를 움직인다.
        //  1. 우선 순위 순으로 움직일 곳을 찾아서 움직인다.
        //      1-1. 움직인 방향으로 방향을 바꿔준다.
        //  2. 같은 곳에 상어가 2마리 이상이면 번호가 제일 낮은 애만 남겨둔다.
        //      2-1. 죽은 애들을 list에 넣어둔다
        //      2-2. 죽은 애들 list의 size가 M-1 이면 그만둔다.
        //  3. 새로운 곳에 냄새 분자 지속 시간을 입력한다.




        System.out.println(answer == 1001 ? -1 : answer);
    }

}