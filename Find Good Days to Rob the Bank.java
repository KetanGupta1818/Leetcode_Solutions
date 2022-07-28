class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> answer = new ArrayList<>();
        List<Range> ascOrder = new ArrayList<>();
        List<Range> dscOrder = new ArrayList<>();
        int i=0,j=0,n=security.length;
        while(j<n){
            while(j<n-1 && security[j]<=security[j+1]) j++;
            ascOrder.add(new Range(i,j));
            i=j+1;
            j++;
        }
        i=0;j=0;
        while(j<n){
            while(j<n-1 && security[j]>=security[j+1]) j++;
            dscOrder.add(new Range(i,j));
            i=j+1;
            j++;
        }
        for(int time1=time;time1<n-time;time1++){
            Range leftRange = new Range(time1-time,time1);
            Range rightRange = new Range(time1,time1+time);
            if(bs(dscOrder,leftRange) && bs(ascOrder,rightRange)) answer.add(time1);
        }
        return answer;
    }
    private boolean bs(List<Range> list, Range range){
        int lo=0,hi=list.size()-1;
        int index = 0;
        while(lo<=hi){
            int m = (lo+hi)>>1;
            if(list.get(m).inRange(range)) {
                return true;
            }
            if(list.get(m).rightSide(range)) lo=m+1;
            else hi=m-1;
        }
        return list.get(Math.max(lo-1,0)).inRange(range);

    }
}
class Range{
    int left;
    int right;

    public Range(int left, int right) {
        this.left = left;
        this.right = right;
    }
    public boolean inRange(Range smaller){
        return this.left<= smaller.left && this.right>= smaller.right;
    }
    public boolean rightSide(Range range){
        return this.right < range.left;
    }
}
