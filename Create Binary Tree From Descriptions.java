class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> setOfChildren = new HashSet<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        for(int[] d: descriptions){
            int parentValue = d[0];
            int childValue = d[1];
            TreeNode pNode = null;
            TreeNode cNode = null;
            if(map.containsKey(parentValue))
                pNode = map.get(parentValue);
            else 
                pNode = new TreeNode(parentValue);
            if(map.containsKey(childValue))
                cNode = map.get(childValue);
            else 
                cNode = new TreeNode(childValue);
            if(d[2]==1) pNode.left = cNode;
            else pNode.right = cNode;
            setOfChildren.add(childValue);
            map.put(childValue,cNode);
            map.put(parentValue,pNode);
            
        }
        TreeNode root = null;
        for(int[] d: descriptions){
            if(!setOfChildren.contains(d[0])){
                root = map.get(d[0]);
                break;
            }
        }
        return root;
    }
}
