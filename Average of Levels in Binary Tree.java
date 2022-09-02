class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> answer = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            double nodes = queue.size();
            double sum = 0;
            for(int s=0;s<nodes;s++){
                TreeNode cur = queue.remove();
                sum += cur.val;
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
            answer.add(sum/nodes);
        }
        return answer;
    }
}
