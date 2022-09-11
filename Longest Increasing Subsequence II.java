/*
    This can be solved using a segment tree
    Time Complexity -> O(NlogN)
    Space Complexity -> O(NlogN)


    Idea-> Create a dp arr which stores the length of LIS ending at that index.
            Use maximum segment tree to get maximum int range and add 1, as this number is also a part of LIS
*/

class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        MaximumSegmentTree sg = new MaximumSegmentTree(new long[1_000_01]);
        for(int num: nums){
            int left = Math.max(0,num-k);
            int right = num-1;
            long nv = sg.getMaximumInclusiveOfRange(left,right);
            sg.update(num,nv+1);
        }
        long max=0;
        for(int i=0;i<=100000;i++) max=Math.max(max,sg.getMaximumInclusiveOfRange(i,i));
        return (int)max;
    }
}
class MaximumSegmentTree{
    private int lengthOfArray;
    private long[] arr;
    private long[] segmentArray;
    private int heightOfSegmentTree;

    public MaximumSegmentTree(long[] a){
        this.lengthOfArray = a.length;
        this.arr = new long[lengthOfArray];
        for(int i=0;i<a.length;i++) arr[i] = a[i];
        this.heightOfSegmentTree = (int)Math.ceil(Math.log(lengthOfArray)/Math.log(2));
        int lengthOfSegmentArray = 2*(1<<heightOfSegmentTree)-1;
        this.segmentArray = new long[lengthOfSegmentArray];
        maximumSegmentTreeConstructorUtil(0,lengthOfArray-1,0);
    }

    private long maximumSegmentTreeConstructorUtil(int segmentStart, int segmentEnd, int segmentIndex){
        if(segmentEnd == segmentStart) return segmentArray[segmentIndex] = arr[segmentStart];
        int mid = getMid(segmentStart,segmentEnd);
        return segmentArray[segmentIndex] = Math.max(maximumSegmentTreeConstructorUtil(segmentStart,mid,segmentIndex*2+1),
                maximumSegmentTreeConstructorUtil(mid+1,segmentEnd,segmentIndex*2+2));
    }

    private int getMid(int segmentStart, int segmentEnd){
        return (segmentStart+segmentEnd)>>1;
    }

    public long getMaximumInclusiveOfRange(int left, int right){
        return getMinimumUtil(0,lengthOfArray-1,left,right,0);
    }
    private long getMinimumUtil(int segmentStart, int segmentEnd, int queryStart, int queryEnd, int segmentIndex){
        if(queryStart<=segmentStart && segmentEnd<=queryEnd) return segmentArray[segmentIndex];
        if(queryEnd<segmentStart || segmentEnd<queryStart) return -1;
        int mid = getMid(segmentStart,segmentEnd);
        return Math.max(getMinimumUtil(segmentStart,mid,queryStart,queryEnd,segmentIndex*2+1),
                getMinimumUtil(mid+1,segmentEnd,queryStart,queryEnd,segmentIndex*2+2));
    }
    public void update(int index, long value){
        updateConstructorUtil(0,lengthOfArray-1,0,index,value);
    }
    private long updateConstructorUtil(int segmentStart, int segmentEnd, int segmentIndex, int index, long newValue){
        if(index>segmentEnd || index<segmentStart) return segmentArray[segmentIndex];
        if(segmentStart==index && segmentEnd==index) return segmentArray[segmentIndex]=newValue;
        int mid = getMid(segmentStart,segmentEnd);
        return segmentArray[segmentIndex]=Math.max(updateConstructorUtil(segmentStart,mid,2*segmentIndex+1,index,newValue),
                updateConstructorUtil(mid+1,segmentEnd,2*segmentIndex+2,index,newValue));
    }
}

