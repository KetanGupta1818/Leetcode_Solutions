class Solution {
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<n/2;i++){
            if(i%2==0) list.add(Math.min(nums[2*i],nums[2*i+1]));
            else list.add(Math.max(nums[2*i],nums[2*i+1]));
        }
        while(list.size()>1) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size() / 2; i++) {
                if(i%2==0) temp.add(Math.min(list.get(2*i+1),list.get(2*i)));
                else temp.add(Math.max(list.get(2*i+1),list.get(2*i)));
            }
            list = temp;
        }
        return list.get(0);
    }
}
