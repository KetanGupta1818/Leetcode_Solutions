class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer,Integer> map_nums2 = new HashMap<>();
        Queue<Integer> Q = new LinkedList<>();
        for(int i=0;i<nums2.length;i++){
            map_nums2.put(nums2[i],i);
        }
        for(int i=0;i<nums1.length;i++){
            int j = map_nums2.get(nums1[i]);
            for(int k=j+1;k<nums2.length;k++){
                if(nums2[k]>nums2[j]){
                    ans[i] = nums2[k];
                    break;
                }
            }
            if(ans[i]==0) ans[i]=-1;
        }
        return ans;
    }
}
