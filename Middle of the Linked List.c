struct ListNode* middleNode(struct ListNode* head){
    if(head->next == NULL) return head;
    struct ListNode *slow = head;
    struct ListNode *fast = head;
    while(fast!=NULL && fast->next!=NULL){
        slow = slow->next;
        fast = fast->next->next;
    }
    return slow;
}
