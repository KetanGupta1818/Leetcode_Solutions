class Solution {
    List<List<Integer>> answer;
    int direction;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> curLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        curLevel.push(root);
        direction = 1; 
        answer = new ArrayList<>();
        if(root == null) return answer;
        return zigzag(curLevel, nextLevel);
    }
    public List<List<Integer>> zigzag( Stack<TreeNode> curLevel, Stack<TreeNode> nextLevel){
        List<Integer> level = new ArrayList<>();
        while(!curLevel.isEmpty()){
            TreeNode temp = curLevel.pop();
            level.add(temp.val);
            if(direction == 1){
                if(temp.left !=null) nextLevel.push(temp.left);
                if(temp.right !=null) nextLevel.push(temp.right);
            }
            else{
                if(temp.right !=null) nextLevel.push(temp.right);
                if(temp.left !=null) nextLevel.push(temp.left);
            }
        }
        direction*=-1;
        answer.add(level);
        if(nextLevel.isEmpty()) return answer;
        return zigzag(nextLevel, curLevel);
    }
}
