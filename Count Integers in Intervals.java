class CountIntervals {
    private TreeMap<Integer,Integer> treeMap;
    private int count;
    public CountIntervals() {
        treeMap = new TreeMap<>();
        count = 0;
    }

    public void add(int left, int right) {
        if(treeMap.floorKey(right)==null || treeMap.get(treeMap.floorKey(right))<left){
            count += right-left+1;
            treeMap.put(left,right);
        }
        else{
            int start = left;
            int end = right;
            while(true){
                int l = treeMap.floorKey(right);
                int r = treeMap.get(l);
                start = Math.min(start,l);
                end = Math.max(end,r);
                count -= r-l+1;
                treeMap.remove(l);
                if(treeMap.floorKey(right)==null || treeMap.get(treeMap.floorKey(right))<left) break;
            }
            count += end - start + 1;
            treeMap.put(start,end);
            //System.out.println(treeMap);
        }
    }

    public int count() {
        return count;
    }
}
/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */
