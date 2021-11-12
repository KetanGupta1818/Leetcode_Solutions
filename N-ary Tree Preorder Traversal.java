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

//Iterative solution
class Solution{
    public List<Integer> preorder(Node root){
        List<Integer> preorderList = new ArrayList<>();
        Stack<Node> stk = new Stack<>();
        if(root == null) return preorderList;
        stk.push(root);
        while(!stk.isEmpty()){
            Node temp = stk.pop();
            preorderList.add(temp.val);
            //System.out.println("Hello");
            if(temp.children!=null) {
                Collections.reverse(temp.children);
                for(Node c : temp.children) stk.push(c);
            }
        }
        return preorderList;
    }
}


