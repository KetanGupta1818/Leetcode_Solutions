public class Solution {
    public int minOperationsToFlip(String expression) {
        String postfix = infixToPostfix(expression);
        TreeNode treeNode = formExpressionTree(postfix);
        return minOperations(treeNode);
    }
    private String infixToPostfix(String expression){
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(c=='0' || c=='1') sb.append(c);
            else if(c=='|' || c=='&'){
                if(!stack.isEmpty() && (stack.peek()=='&' || stack.peek()=='|')) sb.append(stack.pop());
                stack.push(c);
            }
            else{
                if(c==')') {
                    if(stack.peek()!='(') sb.append(stack.pop());
                    stack.pop();
                }

                else stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek()!='(') sb.append(stack.peek());
            stack.pop();
        }
        return sb.toString();
    }
    private TreeNode formExpressionTree(String postfix){
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        for(int i=0;i<postfix.length();i++){
            char c = postfix.charAt(i);
            TreeNode newNode;
            if(c=='0' || c=='1') newNode = new TreeNode(c,c-'0');
            else {
                TreeNode left = stack.pop();
                TreeNode right = stack.pop();
                if(c == '&') newNode = new TreeNode(c,(left.value&right.value));
                else newNode = new TreeNode(c,(left.value|right.value));
                newNode.right = right;
                newNode.left = left;
            }
            stack.push(newNode);
        }
        return stack.pop();
    }
    private int minOperations(TreeNode treeNode){
        char c = treeNode.c;
        if(c == '0' || c == '1') return 1;
        int left_val = treeNode.left.value;
        int right_val = treeNode.right.value;
        if(c == '|'){
            if(left_val==0 && right_val==0) return Math.min(minOperations(treeNode.left),minOperations(treeNode.right));
            else if(left_val==1 && right_val==1) return 1+Math.min(minOperations(treeNode.left),minOperations(treeNode.right));
            else return 1;
        }
        if(left_val==0 && right_val==0) return 1+Math.min(minOperations(treeNode.left),minOperations(treeNode.right));
        else if(left_val==1 && right_val==1) return Math.min(minOperations(treeNode.left),minOperations(treeNode.right));
        return 1;
    }
}
class TreeNode{
    char c;
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(char c, int value){
        this.c = c;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
