class NumArray {
    int[] segmentArray;
    int n;
    int[] arr;
    public NumArray(int[] nums) {
        this.n = nums.length;
        arr = new int[n];
        for(int i=0;i<nums.length;i++) arr[i] = nums[i];
        int height = (int)Math.ceil(Math.log(n)/Math.log(2));
        int size = (int)(2*Math.pow(2,height))-1;
        segmentArray = new int[size];
        constructorUtil(nums,0,n-1,0);
        System.out.println(Arrays.toString(segmentArray));
    }
    private int getMid(int segmentStart, int segmentEnd){
        return segmentStart + (segmentEnd - segmentStart)/2;
    }
    private int constructorUtil(int[] nums, int segmentStart, int segmentEnd, int segmentIndex){
        if(segmentStart == segmentEnd){
            segmentArray[segmentIndex] = nums[segmentStart];
            return segmentArray[segmentIndex];
        }
        int mid = getMid(segmentStart, segmentEnd);
        segmentArray[segmentIndex] = constructorUtil(nums,segmentStart,mid,2*segmentIndex+1) + 
            constructorUtil(nums,mid+1,segmentEnd,2*segmentIndex+2);
        return segmentArray[segmentIndex];
    }
    
    public void update(int index, int val) {
        int oldValue = arr[index];
        arr[index] = val;
        int dif = val - oldValue;
        updateUtil(0,n-1,index,dif,0);
    }
    private void updateUtil(int segmentStart, int segmentEnd, int index,int dif, int segmentIndex){
        if(index<segmentStart || index>segmentEnd) return;
        segmentArray[segmentIndex]+=dif;
        if(segmentStart!=segmentEnd){
            int mid = getMid(segmentStart,segmentEnd);
            updateUtil(segmentStart,mid,index,dif,2*segmentIndex+1);
            updateUtil(mid+1,segmentEnd,index,dif,2*segmentIndex+2);
        }
    }
    
    public int sumRange(int queryStart, int queryEnd) {
        return sumRangeUtil(0,n-1,queryStart,queryEnd,0);
    }
    private int sumRangeUtil(int segmentStart, int segmentEnd, int queryStart, int queryEnd, int segmentIndex){
        if(queryStart<=segmentStart && queryEnd>=segmentEnd) return segmentArray[segmentIndex];
        if(queryStart>segmentEnd || queryEnd<segmentStart) return 0;
        int mid = getMid(segmentStart, segmentEnd);
        return sumRangeUtil(segmentStart,mid,queryStart,queryEnd,2*segmentIndex+1) + 
            sumRangeUtil(mid+1,segmentEnd,queryStart,queryEnd,2*segmentIndex+2);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
