class Solution {
    public String tree2str(TreeNode root) {
        String s = "";
        if(root == null) return s;
        s = Integer.toString(root.val);
        String leftString = tree2str(root.left);
        String rightString = tree2str(root.right);
        if(!rightString.isEmpty()) 
            s = s+ "(" + leftString + ")" + "(" + rightString +")"; 
        else if(!leftString.isEmpty())
            s = s+"("+leftString+")";
        return s;
    }
}
