import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        
        for (int[] e : edge) {
            Node startNode = nodes[e[0] - 1];
            Node endNode = nodes[e[1] - 1];
            startNode.addSiblingNode(endNode);
            endNode.addSiblingNode(startNode);
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes[0]);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            List<Node> nextNodes = node.putDepthAndGetNextNodes();
            for (Node nextNode : nextNodes) {
                queue.add(nextNode);
            }
        }
        
        int max = 0;
        for (Node node : nodes) {
            if (node.getDepth() > max) {
                max = node.getDepth();
            }
        }
        
        for (Node node : nodes) {
            if (node.getDepth() == max) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static class Node {
        private int id;
        private int depth;
        private List<Node> siblingNodes;
        
        public Node(int id) {
            this.id = id;
            this.depth = 0;
            this.siblingNodes = new ArrayList<>();
        }
        
        public void addSiblingNode(Node node) {
            siblingNodes.add(node);
        }
        
        public int getDepth() {
            return depth;
        }
        
        public List<Node> putDepthAndGetNextNodes() {
            List<Node> nextNodes = new ArrayList<>();
            for (Node node : siblingNodes) {
                if (node.id != 0 && node.depth == 0) {
                    node.depth = this.depth + 1;
                    nextNodes.add(node);
                }
            }
            return nextNodes;
        }
        
        public String toString() {
            return id + " " + depth;
        }
    }
}