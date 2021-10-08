class MinStack {
    class stack{
        List<Integer> arr;
        int topv;
        public stack(){
            this.topv = -1;
            this.arr = new ArrayList<>();
        }
    }
    stack stk;
    stack minstk;
    public MinStack() {
        this.stk = new stack();
        this.minstk = new stack();
    }
    
    public void push(int val) {
        if(stk.topv == -1 || minstk.arr.get(minstk.topv)>=val){
            stk.arr.add(val);
            stk.topv++;
            minstk.arr.add(val);
            minstk.topv++;
        }
        else{
            stk.arr.add(val);
            stk.topv++;
        }
    }
    
    public void pop() {
        int val = stk.arr.get(stk.topv);
        stk.arr.remove(stk.topv);
        stk.topv--;
        if(val == minstk.arr.get(minstk.topv)){
            minstk.arr.remove(minstk.topv);
            minstk.topv--;
        }
    }
    
    public int top() {
        return stk.arr.get(stk.topv);
    }
    
    public int getMin() {
        return minstk.arr.get(minstk.topv);
    }
}
