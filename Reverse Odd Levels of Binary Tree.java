class Solution {
    public TreeNode reverseOddLevels(TreeNode ROOT) {
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        Queue<TreeNode> levelOrder = new ArrayDeque<>();
        levelOrder.offer(ROOT);
        int level = 0;
        while(!levelOrder.isEmpty()){
            int size = levelOrder.size();
            for(int s=0;s<size;s++){
                TreeNode cur = levelOrder.remove();
                if(level%2==1){
                    queue.offer(cur.val);
                    stack.push(cur);
                }
                if(cur.left!=null) levelOrder.offer(cur.left);
                if(cur.right!=null) levelOrder.offer(cur.right);
            }
            while(!stack.isEmpty()){
                TreeNode cur = stack.pop();
                cur.val = queue.remove();
            }
            level++;
        }
        return ROOT;
    }
}
