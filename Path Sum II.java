class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root,targetSum,answer,path);
        return answer;
    }
    public void dfs(TreeNode root, int target, List<List<Integer>> answer, List<Integer> path){
        if(root==null) return;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(root.val == target)
                answer.add(new ArrayList<>(path));
            return;
        }
        if(root.left!=null){
            dfs(root.left,target-root.val,answer,path);
            path.remove(path.size()-1);
        }
        if(root.right!=null){
            dfs(root.right, target-root.val,answer,path);
            path.remove(path.size()-1);
        }
        
    }
}
