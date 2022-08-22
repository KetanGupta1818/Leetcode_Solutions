class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        MassUpdateSumSegmentTree massUpdateSumSegmentTree = new MassUpdateSumSegmentTree(new long[s.length()]);
        for(int[] shift: shifts) massUpdateSumSegmentTree.addToSegment(shift[0],shift[1],(shift[2]==1)?1:-1);
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<s.length();i++){
            int val = s.charAt(i)-'a' + (int)massUpdateSumSegmentTree.getValueAtIndex(i);
            if(val>=0) answer.append((char)(97+val%26));
            else if(Math.abs(val)%26==0) answer.append("a");
            else answer.append((char)(26-Math.abs(val%26)+97));
        }
        return answer.toString();
    }
}
class MassUpdateSumSegmentTree{
    int lengthOfArray;
    long[] segmentArray;

    public MassUpdateSumSegmentTree(long[] arr){
        this.lengthOfArray = arr.length;
        int heightOfSegmentTree = (int)Math.ceil(Math.log(lengthOfArray)/Math.log(2));
        int sizeOfSegmentTree = 2*(1<<heightOfSegmentTree)-1;
        this.segmentArray = new long[sizeOfSegmentTree];
    }

    public void addToSegment(int left, int right, long value){
        addUtil(0,lengthOfArray-1,0,left,right,value);
    }

    private void addUtil(int ss, int se, int si, int qs, int qe, long value){
        if(qe<ss || se<qs) return;
        if(qs<=ss && se<=qe) {
            segmentArray[si] += value;
            return;
        }
        int mid = (ss+se)>>1;
        addUtil(ss,mid,2*si+1,qs,qe,value);addUtil(mid+1,se,2*si+2,qs,qe,value);
    }

    public long getValueAtIndex(int index){
        return getIndex(0,lengthOfArray-1,0,index);
    }
    private long getIndex(int ss, int se, int si, int index){
        if(index<ss || index>se) return 0L;
        if(index == ss && index == se) return segmentArray[si];
        int mid = (ss+se)>>1;
        //  if(index == 2) System.out.println("mid: " + mid);
        return getIndex(ss,mid,2*si+1,index)+getIndex(mid+1,se,2*si+2,index)+segmentArray[si];
    }
    public void printSg(){
        System.out.println(Arrays.toString(segmentArray));
    }
}
