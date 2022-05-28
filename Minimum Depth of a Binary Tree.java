class Solution {
    public int minDepth(TreeNode root) {
        int level = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root == null) return 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                if(cur.left == null && cur.right == null) return level;
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            level++;
        }
        return -1;
    }
}
