class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int width=0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> queueIndex = new ArrayDeque<>();
        queue.offer(root);
        queueIndex.offer(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            int start=0,end=0;
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                int index = queueIndex.poll();
                if(i==0) start=index;
                if(i==size-1) end=index;
                if(node.left!=null){
                    queue.offer(node.left);
                    queueIndex.offer(2*index);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                    queueIndex.offer(2*index+1);
                }
            }
            width = Math.max(width,end-start+1);
        }
        return width;
    }
}
