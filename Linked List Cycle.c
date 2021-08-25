/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
bool hasCycle(struct ListNode *head) {
    if(head == NULL || head->next == NULL) return false; //For 0 and 1 Nodes
    if(head->next->next == NULL){                        //For 2 Nodes
        struct ListNode *temp = head;
        temp = temp->next;
        if(temp->next == head) return true;
        else return false;
    }
    //Concept of Fast pointer amd slow pointers.
    struct ListNode *slow = head;
    struct ListNode *fast = head;
    slow = slow->next;          // Slow pointer will move 1 node at a time
    fast = fast->next->next;    // Fast pointer will move 2 nodes at a time
    while(slow->next!=NULL && fast!=NULL){
        if(slow->next == fast->next) return true;
        slow = slow->next;
        if(fast->next!=NULL) fast = fast->next->next;
    }
   //if(slow->next == NULL && fast->next == NULL) return true;
    if(fast==NULL || fast->next==NULL) return false;
    if(slow->next == NULL) return false;
    return true;
}
