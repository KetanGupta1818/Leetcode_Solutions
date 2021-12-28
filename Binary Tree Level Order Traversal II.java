class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root==null) return answer;
        Queue<TreeNode> queue = new ArrayDeque<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sizes = new Stack<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            sizes.push(size);
            for (int i=0;i<size;i++){
                TreeNode currentNode = queue.poll();
                stack.push(currentNode);
                if(currentNode.right!=null) queue.offer(currentNode.right);
                if(currentNode.left!=null) queue.offer(currentNode.left);
            }
        }
        while(!stack.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int currentSize = sizes.pop();
            for(int i=0;i<currentSize;i++){
                list.add(stack.pop().val);
            }
            answer.add(new ArrayList<>(list));
        }
        return answer;
    }
}
