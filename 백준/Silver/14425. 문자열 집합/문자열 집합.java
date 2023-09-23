import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = Integer.parseInt(str.split(" ")[0]);
        int m = Integer.parseInt(str.split(" ")[1]);
        List<String> S = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            S.add(scanner.nextLine());
        }

        int answer = 0;

        for (int i = 0; i < m; i++) {
            if (S.contains(scanner.nextLine())) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}