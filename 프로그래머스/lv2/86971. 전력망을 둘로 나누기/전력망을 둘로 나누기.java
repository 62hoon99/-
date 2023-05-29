import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        List<Vertex> vertexes = new ArrayList<>();
        for (int[] wire : wires) {
            vertexes.add(new Vertex(wire[0], wire[1]));
        }
        
        Collections.sort(vertexes);
        
        Queue<Vertex> queue = new PriorityQueue<>();
        Set<Vertex> set = new HashSet<>();
        for (int i = 0; i < vertexes.size(); i++) {
            vertexes.get(i).disConnect();
            if (i == 0) {
                queue.add(vertexes.get(1));
            }
            if (i != 0) {
                queue.add(vertexes.get(0));
            }
            
            while (!queue.isEmpty()) {
                Vertex vertex = queue.poll();
                int v1 = vertex.getV1();
                int v2 = vertex.getV2();
                
                for (int k = 0; k < vertexes.size(); k++) {
                    if (vertexes.get(k).getV1() > v2) {
                        break;
                    }
                    
                    if (set.contains(vertexes.get(k)) || !vertexes.get(k).isConnect()) {
                        continue;
                    }
                    
                    Vertex currentVertex = vertexes.get(k);
                    if (v1 == currentVertex.getV1() || v1 == currentVertex.getV2() 
                        || v2 == currentVertex.getV1() || v2 == currentVertex.getV2()) {
                        queue.add(currentVertex);
                        set.add(currentVertex);
                    }
                }
            }
            
            int gap = Math.abs((vertexes.size() + 1) - (2 * (set.size() + 1)));
            // System.out.println("idx:" + i + " set.size():" + set.size() + " gap:" + gap);
            if (answer > gap) {
                answer = gap;
            }
            
            vertexes.get(i).connect();
            set.clear();
            queue.clear();
        }
        
        return answer;
    }
    
    static class Vertex implements Comparable<Vertex> {
        private int v1;
        private int v2;
        private boolean connect = true;
        
        public Vertex(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
        
        public int getV1() {
            return v1;
        }
        
        public int getV2() {
            return v2;
        }
        
        public boolean isConnect() {
            return connect;
        }
        
        public void connect() {
            this.connect = true;
        }
        
        public void disConnect() {
            this.connect = false;
        }
        
        public int compareTo(Vertex o) {
            return this.v1 == o.v1 ? this.v2 - o.v2 : this.v1 - o.v1;
        }
    }
}