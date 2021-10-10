class Solution {
    HashSet<Integer> hs;
    List<Integer> answer;
    public List<Integer> rightSideView(TreeNode root) {
        hs = new HashSet<>();
        answer = new ArrayList<>();
        Rsv(root,0);
        return answer;
    }
    public void Rsv(TreeNode root, int level){
        if(root == null) return;
        if(!hs.contains(level)){
            hs.add(level);
            answer.add(root.val);
        }
        level++;
        Rsv(root.right,level);
        Rsv(root.left,level);
    }
}
