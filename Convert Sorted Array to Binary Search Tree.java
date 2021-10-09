class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return formBST(nums, 0, nums.length-1);
    }
    public TreeNode formBST(int[] nums, int left, int right){
        if(left>right) return null;
        int mid = (left+right)/2;
        TreeNode temp = new TreeNode();
        if(left==right) temp.val = nums[left];
        else{
            temp.val = nums[mid];
            temp.left = formBST(nums, left, mid-1);
            temp.right = formBST(nums, mid+1, right);
        }
        return temp;
    }
}
