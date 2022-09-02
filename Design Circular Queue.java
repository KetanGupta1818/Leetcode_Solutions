class MyCircularQueue {
    int[] queue;
    int fp,bp,size,ele;
    public MyCircularQueue(int k) {
        queue = new int[k];
        fp=0;bp=-1;size=k;ele=0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        ele++;
        ++bp;
        queue[bp%size] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        ele--;
        fp++;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return queue[fp%size];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return queue[bp%size];
    }
    
    public boolean isEmpty() {
        return ele==0;
    }
    
    public boolean isFull() {
        return ele==size;
    }
}
