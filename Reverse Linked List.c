struct ListNode* reverseList(struct ListNode* head){
    if(head==NULL || head->next==NULL) return head;
    struct ListNode *SecondEle = head->next;
    head->next = NULL;
    struct ListNode* reversed = reverseList(SecondEle);
    SecondEle->next = head;
    return reversed;
}
