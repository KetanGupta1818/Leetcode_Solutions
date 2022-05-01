class Solution {
    public int countDistinct(int[] nums2, int k, int p) {
        List<Integer> nums = new ArrayList<>();
        for(int i : nums2) nums.add(i);
        Set<List<Integer>> set = new HashSet<>();
        int[] prefix = new int[nums.size()];
        prefix[0] = nums.get(0)%p==0?1:0;
        for(int i=1;i<nums.size();i++)
            prefix[i] = prefix[i-1] + (nums.get(i)%p==0?1:0);
        for(int i=0;i<nums.size();i++){
            for(int j=i+1;j<=nums.size();j++){
                int freq = prefix[j-1] - (i==0?0:prefix[i-1]);
                if(freq<=k){
                    set.add(new ArrayList<>(nums.subList(i,j)));
                }
            }
        }
        return set.size();
    }
}
