class Solution {
    int ans = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(0,root);
        return ans;
    }
    public void dfs(int curNumber, TreeNode root){
        if(root!=null){
            curNumber<<=1;
            curNumber = curNumber+root.val;
            if(root.left == null && root.right==null) ans+=curNumber;
            else{
                dfs(curNumber,root.left);
                dfs(curNumber,root.right);
            }
        }
    }
}
