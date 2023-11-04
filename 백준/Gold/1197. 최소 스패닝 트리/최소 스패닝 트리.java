

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge implements Comparable<Edge> {
    private int v1;
    private int v2;
    private int weight;

    public Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    public int getV1() {
        return v1;
    }

    public int getV2() {
        return v2;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(weight, o.weight);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int V = Integer.parseInt(str[0]);
        int E = Integer.parseInt(str[1]);

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            String[] inputs = br.readLine().split(" ");
            int v1 = Integer.parseInt(inputs[0]);
            int v2 = Integer.parseInt(inputs[1]);
            edges.add(new Edge(Math.min(v1, v2), Math.max(v1, v2), Integer.parseInt(inputs[2])));
        }

        br.close();

        Collections.sort(edges);

        System.out.println(solution(V, edges));
    }

    private static int[] arr;

    private static int solution(int V, List<Edge> edges) {
        arr = new int[V + 1];
        for (int i = 0 ; i < arr.length; i++) {
            arr[i] = i;
        }

        int answer = 0;
        for (Edge edge : edges) {
            if (find(edge.getV1()) != find(edge.getV2())) {
                union(edge.getV1(), edge.getV2());
                answer += edge.getWeight();
            }
        }

        return answer;
    }

    private static void union(int v1, int v2) {
        int a = find(v1);
        int b = find(v2);
        arr[a] = b;
    }

    private static int find(int num) {
        if (arr[num] == num) {
            return num;
        }
        return arr[num] = find(arr[num]);
    }
}