import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] arr = s.split("\\{");
        
        List<Tuple> list = new ArrayList<>();
        for (String str : arr) {
            if (str.trim().isEmpty()) {
                continue;
            }
            
            String[] strsss = str.split(",");
            
            for (int i = 0; i < strsss.length; i++) {
                strsss[i] = strsss[i].replaceAll("}", "");
            }
            
            Tuple tuple = new Tuple();
            for (int i = 0; i < strsss.length; i++) {
                try {
                    tuple.add(Integer.parseInt(strsss[i]));
                } catch (NumberFormatException e) {
                    continue;
                }
            }
            list.add(tuple);
        }
        
        Collections.sort(list);
        List<Integer> answer = new ArrayList<>();
        
        for (Tuple tuple : list) {
            answer.add(tuple.noneMatchValue(answer));
        }
        
        int[] a = new int[answer.size()];
        
        int idx = 0;
        for (int value : answer) {
            a[idx++] = value;
        }
        return a;
    }
    
    static class Tuple implements Comparable<Tuple>{
        private List<Integer> list;
        
        public int noneMatchValue(List<Integer> arr) {
            for (int value : list) {
                if (!arr.contains(value)) {
                    return value;
                }
            }
            return list.get(0);
        }
        
        public Tuple() {
            this.list = new ArrayList<>();
        }
        
        public void add(int value) {
            list.add(value);
        }
        
        public int size() {
            return list.size();
        }
        
        public int compareTo(Tuple o) {
            return list.size() - o.size();
        }
        
        public void print() {
            for (int i : list) {
                System.out.print(i);
            }
        }
    }
}