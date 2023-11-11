

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        br.close();

        Set<String> set = new HashSet<>();
        for (int i = 1; i <= input.length(); i++) {
            for (int k = 0; k + i <= input.length(); k++) {
                set.add(input.substring(k, k + i));
            }
        }

        System.out.println(set.size());
    }

}