
import java.util.*;

class Main {

    private int[] node;
    private int[][] vertex;
    public void solution(int n, int v, int[][] arr) {
        node = new int[n+1];
        vertex = new int[n+1][n+1];

        setVertex(arr);

        dfs(v);
        System.out.println();

        Arrays.fill(node, 0);
        setVertex(arr);

        bfs(v);
        System.out.println();
    }

    private void setVertex(int[][] arr) {
        for (int[] value : arr) {
            vertex[value[0]][value[1]] = 1;
            vertex[value[1]][value[0]] = 1;
        }
    }

    private void dfs(int num) {
        System.out.print(num + " ");
        node[num] = 1;
        for(int i = 1; i < vertex.length; i++) {
            if(vertex[num][i] == 1 && node[i] == 0) {
                vertex[num][i] = 0;
                vertex[i][num] = 0;
                dfs(i);
            }
        }
    }

    private void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        node[num] = 1;

        while(!queue.isEmpty()) {
            Integer data = queue.poll();
            System.out.print(data + " ");
            for(int i = 1; i < vertex.length; i++) {
                if(vertex[data][i] == 1 && node[i] == 0) {
                    vertex[data][i] = 0;
                    vertex[i][data] = 0;
                    node[i] = 1;
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();
        int v=kb.nextInt();
        int[][] arr = new int[m][2];
        for(int i = 0; i < m; i++) {
            for(int k = 0; k < 2; k++) {
                arr[i][k] = kb.nextInt();
            }
        }

        T.solution(n, v, arr);
    }
}