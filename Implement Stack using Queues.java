class MyStack {
    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();
    int top = -1;
    public MyStack() {
        
    }
    
    public void push(int x) {
        q2.add(x);
        top = x;
        while(!q1.isEmpty()) q2.offer(q1.poll());
        Queue<Integer> temp = new ArrayDeque<>();
        temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
        int val = q1.poll();
        if(!q1.isEmpty()) top = q1.peek();
        return val;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}
