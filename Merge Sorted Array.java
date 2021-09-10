class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) return;
        if(m==0){
            for(int i=0;i<n;i++) nums1[i] = nums2[i];
            return;
        }
        int cur = m+n-1;
        m--;
        n--;
        while(cur>=0){
            if(n<0) break;
            if(m<0){
                while(n>=0 && cur>=0) nums1[cur--] = nums2[n--];
                break;
            }
            if(nums2[n]>=nums1[m]) nums1[cur--] = nums2[n--];
            else nums1[cur--] = nums1[m--];
        }
    }
}
