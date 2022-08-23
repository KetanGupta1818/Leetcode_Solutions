class Solution {
    public int amountOfTime(TreeNode root, int start) {
        if(root.left==null && root.right==null) return 0;
        Map<Integer,List<Integer>> tree = new HashMap<>();
       Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node.left!=null){
                List<Integer> parent = tree.getOrDefault(node.val,new ArrayList<>());
                List<Integer> child = tree.getOrDefault(node.left.val,new ArrayList<>());
                parent.add(node.left.val);
                child.add(node.val);
                tree.put(node.val,parent);
                tree.put(node.left.val,child);
                queue.offer(node.left);
            }
            if(node.right!=null){
                List<Integer> parent = tree.getOrDefault(node.val,new ArrayList<>());
                List<Integer> child = tree.getOrDefault(node.right.val,new ArrayList<>());
                parent.add(node.right.val);
                child.add(node.val);
                tree.put(node.val,parent);
                tree.put(node.right.val,child);
                queue.offer(node.right);
            }
        }
        HashSet<Integer> visited = new HashSet<>();
        visited.add(start);
        Queue<Integer> queue1 = new ArrayDeque<>();
        queue1.offer(start);
        int level=0;
        while(!queue1.isEmpty()){
            int size = queue1.size();
            for(int s=0;s<size;s++){
                int node = queue1.remove();
                for(int child: tree.get(node)){
                    if(visited.add(child)){
                        queue1.offer(child);
                    }
                }
            }
            level++;
        }
        return level-1;
    }
}
