//This solution exceeds time in just one test case as creation of hashmap and checking of k - root.val are done in two different recursions.
class Solution {
    public boolean findTarget(TreeNode root, int k) {
    	HashSet<Integer> hs = new HashSet<>();
        hs = addToHashSet(root,hs);
        System.out.println(hs + " Size of hashset: " + hs.size());
        //While traversing the tree check if sum is present in the hash set or not
        return isSumPresent(root, hs, k);
    }
    public HashSet<Integer> addToHashSet(TreeNode root, HashSet<Integer> hs){
    	if(root == null) return hs;
    	hs.add(root.val);
    	hs.addAll(addToHashSet(root.left,hs));
    	hs.addAll(addToHashSet(root.right,hs));
    	return hs;
    }
    public boolean isSumPresent(TreeNode root, HashSet<Integer> hs, int k) {
    	if(root == null) return false;
    	int counter_x = k - root.val;
    	if(hs.contains(counter_x) && counter_x!=root.val) return true;
    	return isSumPresent(root.left, hs, k) || isSumPresent(root.right, hs, k);
    }
}
//In this solution Creation of hashmap and checking of k - root.val are done in single recursion.
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hs = new HashSet<>();
        return sumChecker(hs, root, k);
    }
    public boolean sumChecker(HashSet<Integer> hs, TreeNode root, int k){
        if(root == null) return false;
        if(hs.contains(k-root.val)) return true;
        hs.add(root.val);
        return sumChecker(hs,root.left,k) || sumChecker(hs,root.right,k);
    }
}
