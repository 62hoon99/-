import java.util.*;

class Solution {
    public int solution(String[][] book_times) {
        int answer = 0;
        
        // 시작 시각이 되면 우선순위 큐에 넣는다.
        // 우선순위 큐는 종료시간이 빠른 순이다.
        // 시작시간 오름차순으로 정렬된 예약을 큐에 넣기전에 큐에서 넣으려는 예약의 시작시간보다 마감시간이 더 작은 방을 빼낸다.
        // 정답은 큐의 사이즈가 최대일 때이다.
        List<Book> books = new ArrayList<>();
        
        for (String[] book_time : book_times) {
            Time startTime = new Time(book_time[0]);
            Time endTime = new Time(book_time[1]);
            books.add(new Book(startTime, endTime));
        }
        
        Collections.sort(books);
        
        Queue<Room> queue = new PriorityQueue<>();
        
        for (int i = 0; i < books.size(); i++) {
            Room newRoom = new Room(books.get(i));
            
            while (!queue.isEmpty()) {
                Room room = queue.poll();
                // System.out.println(room);
                if (!room.isChangealbe(newRoom)) {
                    queue.add(room);
                    break;
                }
            }
            
            queue.add(newRoom);
            
            if (answer < queue.size()) {
                answer = queue.size();
            }
        }
        
        return answer;
    }
    
    static class Time {
        private int time;
        
        public Time(String timeStr) {
            String[] split = timeStr.split(":");
            this.time = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }
        
        public boolean isBiggerThan(Time o) {
            return time > o.time;
        }
        
        public String toString() {
            return String.valueOf(time);
        }
        
        public void plus(int time) {
            this.time += time;
        }
    }
    
    static class Book implements Comparable<Book> {
        private Time startTime;
        private Time endTime;
        
        public Book(Time startTime, Time endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
        
        public int compareTo(Book o) {
            if (startTime.isBiggerThan(o.startTime)) {
                return 1;
            }
            return -1;
        }
        
        public String toString() {
            return "startTime: " + startTime + " endTime: " + endTime;
        }
        
        public boolean isEndTimeBiggerThan(Book o) {
            return endTime.isBiggerThan(o.endTime);
        }
        
        public void plusEndTime(int time) {
            this.endTime.plus(time);
        }
        
        public boolean isEndTimeSmallerOrEqualThanStartTime(Book o) {
            if (!endTime.isBiggerThan(o.startTime)) {
                return true;
            }
            return false;
        }
    }
    
    static class Room implements Comparable<Room> {
        private Book book;
        
        public Room(Book book) {
            book.plusEndTime(10);
            this.book = book;
        }
        
        public int compareTo(Room o) {
            if (book.isEndTimeBiggerThan(o.book)) {
                return 1;
            }
            return -1;
        }
        
        public boolean isChangealbe(Room o) {
            if (book.isEndTimeSmallerOrEqualThanStartTime(o.book)) {
                return true;
            }
            return false;
        }
        
        public String toString() {
            return book.toString();
        }
    }
    
}