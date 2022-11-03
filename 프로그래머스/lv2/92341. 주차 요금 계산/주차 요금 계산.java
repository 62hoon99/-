import java.util.*;

class Solution {
        public int[] solution(int[] fees, String[] records) {
        //hashmap으로 받음
        //hashmap에서 key는 차번호 value는 시간
        //hashmap에서 key로 갖고 있는 경우
        
        //다른 hashmap 만듬
        //이 hashmap에서는 주차 요금을 계산할거임
        //key는 차번호 value는 총 시간 합산
        Map<String, String> stackTable = new HashMap<>();
        Map<String, Integer> timeTable = new HashMap<>();
        
        for(String record : records) {
            String[] recorded = record.split(" ");
            if(stackTable.containsKey(recorded[1])) {
                String[] preTime = stackTable.get(recorded[1]).split(":");
                String[] postTime = recorded[0].split(":");
                
                if(timeTable.containsKey(recorded[1])) 
                    timeTable.put(recorded[1], timeTable.get(recorded[1]) + takenTime(preTime, postTime));
                else timeTable.put(recorded[1], takenTime(preTime, postTime));
                stackTable.remove(recorded[1]);
            } else {
                stackTable.put(recorded[1], recorded[0]);
            }
        }
        
        if(stackTable.size() > 0) {
            for(String carNumber : stackTable.keySet()) {
            String[] preTime = stackTable.get(carNumber).split(":");
            String[] postTime = {"23", "59"};
            
            if(timeTable.containsKey(carNumber)) 
                timeTable.put(carNumber, timeTable.get(carNumber) + takenTime(preTime, postTime));
            else timeTable.put(carNumber, takenTime(preTime, postTime));
            // stackTable.remove(carNumber);
            }
        }
        
        for(String carNumber : timeTable.keySet()) {
            timeTable.put(carNumber, calcFee(fees, timeTable.get(carNumber)));
        }
        
                List<Integer> answer = new ArrayList<>();
        timeTable.keySet().stream().sorted()
            .forEach(key -> answer.add(timeTable.get(key)));
            
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int takenTime(String[] preTime, String[] postTime) {
        int hour = Integer.parseInt(postTime[0]) - Integer.parseInt(preTime[0]);
        int minute = Integer.parseInt(postTime[1]) - Integer.parseInt(preTime[1]);
        if(minute < 0) {
            hour -= 1;
            minute += 60;
        }
        
        return (hour*60) + minute;
    }
    
    private int calcFee(int[] fees, int time) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        int totalFee = 0;
        
        if(time <= basicTime) return basicFee;
        totalFee = (time - basicTime) / unitTime;
        if((time - basicTime) % unitTime != 0) totalFee += 1;
        
        totalFee = totalFee * unitFee + basicFee;
        return totalFee;
    }
}