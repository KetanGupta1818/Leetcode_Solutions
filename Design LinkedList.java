class MyLinkedList {
    class Node{
            int val;
            Node next;
            public Node(int val){
                this.val = val;
                this.next = null;
            }
        }
    int length;
    Node head;
        
    public MyLinkedList() {
        this.length = 0;
        this.head = null;
    }
    
    public int get(int index) {
        if(index<0 || index>=this.length) return -1;
        int counter = 0;
        Node temp = this.head;
        while(counter!=index){
            temp = temp.next;
            counter++;
        }
        if(temp==null) return -1;
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node temp = this.head;
        if(this.length == 0){
            addAtHead(val);
            return;
        }
        while(temp.next!=null) temp = temp.next;
        temp.next = newNode;
        this.length++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index == 0){ addAtHead(val);return;}
        if(index == this.length){ addAtTail(val); return;}
        if(index > this.length) return;
        int counter = 0;
        Node newNode = new Node(val);
        Node cur = this.head;
        while(counter!=(index-1)){ cur = cur.next;counter++;}
        if(cur==null) return;
        newNode.next = cur.next;
        cur.next = newNode;
        this.length++;
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=this.length) return;
        Node cur = this.head;
        if(index==0){
            cur = cur.next;
            this.head = cur;
            return;
        }
        int counter = 0;
        while(counter!=index-1 ){ cur = cur.next;counter++;}
        if(cur==null) return;
        Node del = cur.next;
        cur.next = del.next;
        this.length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
