class FreqStack {
    Map<Integer, Integer> freq = new HashMap<>();
    Map<Integer, Stack<Integer>> group = new HashMap<>();
    int maxFreq;
    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val,0)+1;
        freq.put(val,f);
        if(f>maxFreq) maxFreq=f;
        group.computeIfAbsent(f,z -> new Stack<Integer>()).push(val);
    }
    
    public int pop() {
        int x = group.get(maxFreq).pop();
        if(group.get(maxFreq).size()==0) maxFreq--;
        freq.put(x,freq.get(x)-1);
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
