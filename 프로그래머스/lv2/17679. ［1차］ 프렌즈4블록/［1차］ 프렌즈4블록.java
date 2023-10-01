import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        List<List<String>> boards = new ArrayList<List<String>>();
        
        for (int i = 0; i < n; i++) {
            boards.add(new ArrayList<>());
        }
        
        for (int k = m - 1; k >= 0; k--) {
            String[] strs = board[k].split("");
            for (int i = strs.length - 1; i >= 0; i--) {
                boards.get(i).add(strs[i]);
            }
        }
        
        while (true) {
            Set<Point> points = new HashSet<>();
            for (int i = 0; i < n - 1; i++) {
                for (int k = 0; k < m - 1; k++) {
                    String w1 = boards.get(i).get(k);
                    String w2 = boards.get(i).get(k + 1);
                    String w3 = boards.get(i + 1).get(k);
                    String w4 = boards.get(i + 1).get(k + 1);
                    if (!w1.equals(" ") && w1.equals(w2) && w2.equals(w3) && w3.equals(w4)) {
                        points.addAll(List.of(new Point(i , k), new Point(i, k + 1),
                                              new Point(i + 1, k), new Point(i + 1, k + 1)));
                        //System.out.println("i: " + i + " k: " + k);
                    }
                }
            }
                                      
            if (points.isEmpty()) {
                break;
            }
            
            List<Point> pList = new ArrayList<>(points);
            
            Collections.sort(pList);
            
            for (Point point : pList) {
                List<String> col = boards.get(point.x);
                col.remove(point.y);
                col.add(" ");
                answer++;
            }
            
            // 디버깅
            //for (int i = m - 1; i >= 0; i--) {
                //for (int k = 0; k < n; k++) {
                    //System.out.print(boards.get(k).get(i));
                //}
                //System.out.println();
            //}
            //System.out.println();
        }
        
        return answer;
    }
    

    static class Point implements Comparable<Point> {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point o) {
            return Integer.compare(o.y, this.y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}