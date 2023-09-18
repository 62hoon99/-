

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.nextLine();

        String line = scanner.nextLine();
        List<Integer> stds = Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        System.out.println(solution(stds));
    }

    private static String solution(List<Integer> stds) {
        String answer = "Nice";

        Stack<Integer> line = new Stack<>();
        Stack<Integer> side = new Stack<>();

        for (int i = stds.size() - 1; i >= 0; i--) {
            line.push(stds.get(i));
        }

        // side에 제일 위에 있는 애보다 더 큰 값이 들어오면 그냥 끝남

        int index = 1;
        while (!line.isEmpty()) {
            if (line.peek() == index) {
                line.pop();
                index++;
                continue;
            }
            if (!side.isEmpty() && side.peek() == index) {
                side.pop();
                index++;
                continue;
            }

            Integer first = line.pop();
            if (!side.isEmpty() && side.peek() < first) {
                answer = "Sad";
                break;
            }
            side.push(first);
        }

        return answer;
    }

}