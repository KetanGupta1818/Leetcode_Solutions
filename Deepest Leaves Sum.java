class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int sum=0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            sum = 0;
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                sum += cur.val;
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
        }
        return sum;
    }
}
