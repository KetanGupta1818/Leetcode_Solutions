class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        List<Integer> currentLevelOrderList = new ArrayList<>();
        if(root == null) return levelOrderList;
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
        Q.add(null);
        while(!Q.isEmpty()){
            Node temp = Q.remove();
            if(temp!=null) currentLevelOrderList.add(temp.val);
            if(temp == null){
                if(!Q.isEmpty()){
                    Q.add(null);
                    levelOrderList.add(new ArrayList(currentLevelOrderList));
                    currentLevelOrderList.clear();
                }
                else levelOrderList.add(new ArrayList(currentLevelOrderList));
                continue;
            }
            
            if(!temp.children.isEmpty()){
                for(Node child: temp.children) Q.add(child);
            }
        }
        return levelOrderList;
    }
}
