import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        // HEAD는 숫자가 나오기 전 문자열, 대소문자 구분 안하고 사전순 정렬
        // NUMBER는 숫자가 아닌 문자가 나오기 전까지의 숫자, 앞에 0은 없애고 순서대로 정렬
        // TAIL은 신경 ㄴㄴ, HEAD와 NUMBER 까지 같다면 들어온 순서대로
        
        List<File> fileList = new ArrayList<>();
        for (int i = 0 ; i < files.length; i++) {
            fileList.add(new File(files[i], i));
        }
        
        Collections.sort(fileList);

        int idx = 0;
        for (File file : fileList) {
            // System.out.println(file);
            answer[idx++] = file.fileName;
        }
        
        return answer;
    }
    
    private static class File implements Comparable<File> {
        private String fileName;
        private String head;
        private int number;
        private int idx;
        
        public File(String fileName, int idx) {
            this.fileName = fileName;
            this.idx = idx;
            
            StringBuilder sb = new StringBuilder();
            boolean flag = true;
            for (char c : fileName.toCharArray()) {
                if (flag && Character.isDigit(c)) {
                    head = sb.toString();
                    sb = new StringBuilder();
                    flag = false;
                }
                if (!flag && !Character.isDigit(c)) {
                    number = Integer.parseInt(sb.toString());
                    flag = true;
                    break;
                }
                sb.append(c);
            }
            
            if (!flag) {
                number = Integer.parseInt(sb.toString());
            }
        }
        
        public int compareTo(File o) {
            int headCompre = head.compareToIgnoreCase(o.head);
            if (headCompre == 0) {
                int numberCompare = Integer.compare(number, o.number);
                if (numberCompare == 0) {
                    return Integer.compare(idx, o.idx);
                }
                return numberCompare;
            }
            return headCompre;
        }
        
        public String toString() {
            return "filName: " + fileName + " HEAD: " + head + " NUMBER: " + number; 
        }
    }
}