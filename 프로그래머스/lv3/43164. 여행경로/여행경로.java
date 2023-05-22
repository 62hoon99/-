import java.util.*;

class Solution {
    private int[] check;
    private String[] answer;
    
    public String[] solution(String[][] tickets) {
        List<Ticket> ticketList = new ArrayList<>();
        for (String[] ticket : tickets) {
            ticketList.add(new Ticket(ticket[0], ticket[1]));
        }
        
        Collections.sort(ticketList);
        check = new int[ticketList.size()];
        answer = new String[ticketList.size() + 1];
        
        dfs(ticketList, "ICN", 0);
        
        return answer;
    }
    
    private void dfs(List<Ticket> tickets, String start, int depth) {
        if (tickets.size() == depth) {
            return;
        }
        
        for (int i = 0; i < tickets.size(); i++) {
            if (check[i] == 1) {
                continue;
            }
            
            Ticket ticket = tickets.get(i);
            
            if (ticket.equalsStart(start)) {
                check[i] = 1;
                answer[depth] = start; 
                answer[depth + 1] = ticket.getEnd();
                dfs(tickets, ticket.getEnd(), depth + 1);
                if (answer[tickets.size()] != null) {
                    break;
                }
                check[i] = 0;
            }
        }
    }
    
    static class Ticket implements Comparable<Ticket> {
        private String start;
        private String end;
        
        public Ticket(String start, String end) {
            this.start = start;
            this.end = end;
        }
        
        public String getEnd() {
            return end;
        }
        
        public boolean equalsStart(String start) {
            return this.start.equals(start);
        }
        
        public int compareTo(Ticket o) {
            return start.compareTo(o.start) == 0 ? end.compareTo(o.end) : start.compareTo(o.start);
        }
        
        public String toString() {
            return start + " " + end;
        }
    }
}