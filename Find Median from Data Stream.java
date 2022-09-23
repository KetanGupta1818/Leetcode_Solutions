class MedianFinder {
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        int pos = searchInsertPosition(num);
        list.add(pos,num);
    }

    public double findMedian() {
        if(list.size()%2==1) return list.get(list.size()/2)*1D;
        return (list.get(list.size()/2)+list.get(list.size()/2-1))/2D;
    }
    private int searchInsertPosition(int target){
        int lo=0,hi=list.size()-1;
        while(lo<=hi){
            int m = (lo+hi)>>1;
            if(list.get(m)>=target) hi=m-1;
            else lo=m+1;
        }
        return hi+1;
    }
}
