import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 시간을 돌면서 요청시간이 되면 큐에 넣는다.
        // 작업 가능 시점에 큐에 있는 것 중 작업 시간이 제일 짧은 거 실행한다.
        
        List<JobForOrder> jobOrderList = new ArrayList<>();
        Queue<Job> queue = new PriorityQueue<>();
        
        for (int[] job : jobs) {
            jobOrderList.add(new JobForOrder(job[0], job[1]));
        }
        Collections.sort(jobOrderList);
        
        int idx = 0;
        int endTime = 0;
        for (int i = 0; i < 1_001; i++) {
            while(idx < jobOrderList.size() && jobOrderList.get(idx).requestTime == i) {
                queue.add(Job.from(jobOrderList.get(idx++)));
            }
            
            if (i >= endTime) {
                if (!queue.isEmpty()) {
                    Job nextJob = queue.poll();
                    // System.out.println(nextJob);
                    answer += nextJob.totalTime(i);
                    endTime = nextJob.endTime(i);
                }
            }
        }
        
        while (!queue.isEmpty()) {
            Job nextJob = queue.poll();
            // System.out.println(nextJob + "*");
            answer += nextJob.totalTime(endTime);
            endTime = nextJob.endTime(endTime);
        }
        
        
        return answer / jobs.length;
    }
    
    static class Job implements Comparable<Job> {
        private int requestTime;
        private int workingTime;
        
        public Job(int req, int work) {
            this.requestTime = req;
            this.workingTime = work;
        }
        
        public static Job from(JobForOrder jobForOrder) {
            return new Job(jobForOrder.requestTime, jobForOrder.workingTime);
        }
        
        public int endTime(int currentTime) {
            return currentTime + workingTime;
        }
        
        public int totalTime(int currentTime) {
            return currentTime + workingTime - requestTime;
        }
        
        public int compareTo(Job o) {
            return this.workingTime - o.workingTime;
        }
        
        public String toString() {
            return "requetTime: " + requestTime + " workingTime: " + workingTime;
        }
    }
    
    static class JobForOrder implements Comparable<JobForOrder> {
        int requestTime;
        int workingTime;
        
        public JobForOrder(int req, int work) {
            this.requestTime = req;
            this.workingTime = work;
        }
        
        public int compareTo(JobForOrder o) {
            return this.requestTime - o.requestTime;
        }
    }
}