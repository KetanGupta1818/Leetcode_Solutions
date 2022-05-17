class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null) return null;
        if(original.val == target.val) return cloned;
        TreeNode l = getTargetCopy(original.left,cloned.left,target);
        if(l!=null) return l;
        return getTargetCopy(original.right,cloned.right,target);
    }
}
