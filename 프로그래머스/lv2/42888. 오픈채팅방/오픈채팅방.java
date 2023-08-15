import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        Map<String, String> userMap = new HashMap<>();
        
        List<List<String>> records = new ArrayList<>();
        for (String r : record) {
            records.add(List.of(r.split(" ")));
        }
        
        for (List<String> r : records) {
            if (!r.get(0).equals("Leave")) {
                userMap.put(r.get(1), r.get(2));
            }
        }
        
        int answerSize = 0;
        for (List<String> r : records) {
            if (!r.get(0).equals("Change")) {
                answerSize++;
            }
        }
        
        answer = new String[answerSize];
        int index = 0;
        for (List<String> r : records) {
            if (r.get(0).equals("Enter")) {
                answer[index++] = userMap.get(r.get(1)) + "님이 들어왔습니다.";
            }
            if (r.get(0).equals("Leave")) {
                answer[index++] = userMap.get(r.get(1)) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}