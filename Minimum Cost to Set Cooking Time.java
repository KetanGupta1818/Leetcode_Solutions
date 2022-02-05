class Solution {
   //Make a list of digits to be pressed. If (minutes>=100 then list=null) || (seconds>=100 then list=null)
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int minutes = targetSeconds/60;
        int seconds = targetSeconds%60;
        List<Integer> time1 = calculateTimeArray(minutes,seconds);
        List<Integer> time2 =  calculateTimeArray(minutes-1,seconds+60);
        return Math.min(calculateCost(startAt,moveCost,pushCost,time1),calculateCost(startAt,moveCost,pushCost,time2));
    }
    public int calculateCost(int startAt,int moveCost, int pushCost, List<Integer> time){
        if(time==null) return Integer.MAX_VALUE;
        int cost=0,index=0;
        while(time.get(index)==0) index++; //Always skip starting zeros even if you are at zero as they cost pushCost
        int currentPosition = startAt;
        while(index<=3){
            if(currentPosition==time.get(index)) cost+=pushCost;
            else{
                currentPosition=time.get(index);
                cost+=pushCost+moveCost;
            }
            index++;
        }
        return cost;
    }
    public List<Integer> calculateTimeArray(int minutes, int seconds){
        if(minutes>=100 || seconds>=100) return null;
        List<Integer> time = new ArrayList<>();
        time.add(minutes/10);
        time.add(minutes%10);
        time.add(seconds/10);
        time.add(seconds%10);
        return time;
    }
}
