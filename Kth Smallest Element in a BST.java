class Solution {
    int answer;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        inorder(root,k);
        return answer;
    }
    public void inorder(TreeNode root, int k){
        if(root == null) return;
        inorder(root.left,k);
        count++;
        if(count==k){
            answer = root.val;
            return;
        }
        inorder(root.right,k);
    }
}
