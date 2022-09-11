/**
  Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++) list.add(i);
        return f(list);
    }
    private List<TreeNode> f(List<Integer> list){
        if(list.size()==0) return new ArrayList<>();
        if(list.size()==1) return List.of(new TreeNode(list.get(0)));
        List<TreeNode> curList = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            List<TreeNode> leftSide = f(list.subList(0,i));
            List<TreeNode> rightSide = f(list.subList(i+1,list.size()));
            if(leftSide.isEmpty()) {
                for(TreeNode rightNode: rightSide){
                    TreeNode node = new TreeNode(list.get(i));
                    node.right = rightNode;
                    curList.add(node);
                }
                
            }
            else if(rightSide.isEmpty()){
                for(TreeNode leftNode: leftSide){
                    TreeNode node = new TreeNode(list.get(i));
                    node.left = leftNode;
                    curList.add(node);
                }
            }
            else{
                for(TreeNode leftNode: leftSide){
                    for(TreeNode rightNode: rightSide){
                        TreeNode node = new TreeNode(list.get(i));
                        node.left = leftNode;
                        node.right = rightNode;
                        curList.add(node);
                    }
                }
            }
        }
        return curList;
    }
}
