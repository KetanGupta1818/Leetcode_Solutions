class Solution {
    public int maxDepth(TreeNode root) {
     	int level = 0;
    	if(root == null) return level;
    	TreeNode temp = new TreeNode();
    	Queue<TreeNode> Q = new LinkedList<>();
    	Q.add(root);
    	Q.add(null);
    	while(!Q.isEmpty()) {
    		temp = Q.remove();
    		if(temp == null) {
    			level++;
    			if(!Q.isEmpty()) Q.add(null);
    		}
    		else {
    			if(temp.left!=null) Q.add(temp.left);
    			if(temp.right!=null) Q.add(temp.right);
    		}
    	}
    	return level;       
    }
}
