public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        
        while(true){
            int mid = left + (right - left)/2;
            if(isBadVersion(mid) == false){
                left = mid+1;
            }
            else{
                if(mid == 1) return 1;
                else if(isBadVersion(mid-1) == false) return mid;
                right = mid-1;
            }
        }
    }
}
