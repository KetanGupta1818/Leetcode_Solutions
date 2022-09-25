class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeMap<Integer,Integer> freq = new TreeMap<>();
        int n = nums.length;
        for(int i=0;i<=indexDiff;i++){
            if(i==n) break;
            int num = nums[i];
            Integer ceil = freq.ceilingKey(num);
            Integer floor = freq.floorKey(num);
            if(ceil!=null && ceil-num<=valueDiff) return true;
            if(floor!=null && num-floor<=valueDiff) return true;
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        for(int rp=indexDiff+1;rp<n;rp++){
            int lp = rp-indexDiff-1;
            int vd = nums[lp];
            freq.put(vd,freq.get(vd)-1);
            if(freq.get(vd)==0) freq.remove(vd);
            int num = nums[rp];
            Integer ceil = freq.ceilingKey(num);
            Integer floor = freq.floorKey(num);
            if(ceil!=null && ceil-num<=valueDiff) return true;
            if(floor!=null && num-floor<=valueDiff) return true;
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        return false;
    }
}
