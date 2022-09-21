class Solution {
    public int totalSteps(int[] nums) {
        int cur_max = -1, answer = 0;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        for(int num: nums){
            if(cur_max<=num){
                cur_max = num;
                stack = new ArrayDeque<>();
                stack.push(new Node(num,0,Integer.MAX_VALUE));
            }
            else{
                while(stack.peek().value<=num) stack.pop();
                Node parent = stack.pop();
                Node child = new Node(num,0,++parent.helped);
                answer = Math.max(answer,parent.helped);
                if(parent.helped<parent.rank) stack.push(parent);
                stack.push(child);
            }
        }
        return answer;
    }
}
class Node{
    int value;
    int helped;
    int rank;
    
    public Node(int value, int helped, int rank){
        this.value = value;
        this.helped = helped;
        this.rank = rank;
    }
}
