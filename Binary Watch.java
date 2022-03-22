class Solution {
    public Set<String> answerSet = new HashSet<>();
    public List<String> readBinaryWatch(int turnedOn) {
        if(turnedOn==9 || turnedOn==10) return new ArrayList<>();
        backTrack(0,0,0,turnedOn);
        List<String> answer = new ArrayList<>(answerSet);
        return answer;
    }
    public void backTrack(int hours, int minutes, int currentLightsOn, int turnedOn){
        if(currentLightsOn==turnedOn){
            String H = Integer.toString(hours);
            String M = Integer.toString(minutes);
            if(M.length()==1) M = "0"+M;
            answerSet.add(H + ":" + M);
            return;
        }
        for(int m=0;m<6;m++){
            int val = 1 << m;
            if(((minutes>>m)&1)==1) continue;
            if(minutes+val>59) return;
            backTrack(hours,minutes+val,currentLightsOn+1,turnedOn);
        }
        for(int h=0;h<4;h++){
            int val = 1 << h;
            if(((hours>>h)&1)==1) continue;
            if(hours+val>11) return;
            backTrack(hours+val,minutes,currentLightsOn+1,turnedOn);
        }

    }
}
