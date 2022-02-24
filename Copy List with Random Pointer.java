class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node nhead = new Node(head.val);
        Node cur = nhead;
        Map<Node,Node> map = new HashMap<>();
        map.put(null,null);
        map.put(head,nhead);
        if(head.random!=null){
            map.put(head.random,new Node(Integer.MAX_VALUE));
        }
        cur.random = map.get(head.random);
        if(head.random==head){
            cur.random = nhead;
        }
        head = head.next;
        while(head!=null){
            Node newNode = map.getOrDefault(head,new Node(head.val));
            if(newNode.val==Integer.MAX_VALUE) newNode.val = head.val;
            newNode.random = map.getOrDefault(head.random,new Node(Integer.MAX_VALUE));
            if(head.random==head){
                newNode.random = newNode;
            }
            map.put(head,newNode);
            map.put(head.random,newNode.random);
            cur.next = newNode;
            cur = cur.next;
            
            head = head.next;
        }
        return nhead;
    }
}
