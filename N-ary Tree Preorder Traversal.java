class Solution {
    
    List<Integer> preorderList = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null) return preorderList;
        preorderList.add(root.val);
        if(root.children == null) return preorderList;
        root.children.stream().forEach(child->preorder(child));
        return preorderList;
    }
}
