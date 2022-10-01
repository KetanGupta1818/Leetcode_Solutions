class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return f(nums,0,nums.length-1);
    }
    private int getIndexOfMaximumValue(int[] nums, int left, int right){
        if(left == right) return left;
        int max = 0;
        int index = -1;
        for(int i=left;i<=right;i++){
            if(max<nums[i]){
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
    private TreeNode f(int[] nums, int left, int right){
        if(left>right) return null;
        int maxIndex = getIndexOfMaximumValue(nums,left,right);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = f(nums,left,maxIndex-1);
        root.right = f(nums,maxIndex+1,right);
        return root;
    }
}
