class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak=-1,lo=0,hi=mountainArr.length()-1;
        while(lo<=hi){
            int m = lo + (hi-lo)/2;
            int cur = mountainArr.get(m);
            int cur_left = -1;
            if(m!=0) cur_left = mountainArr.get(m-1);
            int cur_right = -1;
            if(m!= mountainArr.length()-1) cur_right =  mountainArr.get(m+1);
            if(cur>cur_right && cur>cur_left){
                peak = m;
                break;
            } 
            else if(cur>cur_right && cur<cur_left) {
                
                hi = m-1;
            }
            else lo = m+1;
        }
        if(peak == -1){
            System.out.println("Could not fing peak");
            return -1;
        }
        if(target==mountainArr.get(peak)) return peak;
        if(target > mountainArr.get(peak)) return -1;
        int left_response = find(target,mountainArr,0,peak-1);
        if(left_response!=-1) return left_response;
        return find2(target,mountainArr,peak+1,mountainArr.length()-1);
        
    }
    private int find(int target, MountainArray mountainArr, int lo, int hi){
        while(lo<=hi){
            int m = lo + (hi-lo)/2;
            int cur = mountainArr.get(m);
            if(cur == target) return m;
            else if(cur > target) hi = m -1;
            else lo = m + 1;
        }
        return -1;
    }
    private int find2(int target, MountainArray mountainArr, int lo, int hi){
        while(lo<=hi){
            int m = lo + (hi-lo)/2;
            int cur = mountainArr.get(m);
            if(cur == target) return m;
            else if(cur > target) lo = m+1;
            else hi = m-1;
        }
        return -1;
    }
}
