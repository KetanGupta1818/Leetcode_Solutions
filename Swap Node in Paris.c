struct ListNode* swapPairs(struct ListNode* head){
    if(head==NULL || head->next==NULL) return head;
    struct ListNode* temp1 = head;
    struct ListNode* back = head;
    struct ListNode* temp2 = head->next;
    head = temp2;
    while(temp1!=NULL && temp1->next!=NULL){
        back->next = temp2;
        temp1->next = temp2->next;
        temp2->next = temp1;
        back = temp1;
        temp1 = temp1->next;
        if(temp1!=NULL) temp2 = temp1->next;
    }
    return head;
}
//----------------------------------------------------------------------
//With Recursion
struct ListNode* swapPairs(struct ListNode* head){
    if(head==NULL || head->next==NULL) return head;
    struct ListNode *second = head->next;
    struct ListNode *reversed = swapPairs(second->next);
    second->next = head;
    head->next = reversed;
    reversed = second;
    return reversed;
    
}
