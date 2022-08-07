class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long day = 1L;
        Map<Integer,Long> minimumDay = new HashMap<>();
        for(int task:tasks){
            long miniDay = minimumDay.getOrDefault(task,0L);
            day = Math.max(miniDay,day);
            minimumDay.put(task,day+space+1);
            day++;
        }
        return day-1;
    }
}
