struct ListNode* rotateRight(struct ListNode* head, int k){
    if(head==NULL || head->next==NULL) return head;
    struct ListNode *last = head;
    int n=1;
    while(last->next!=NULL){
        last = last->next;
        n++;
    }
    int real_shift = k - n*(k/n);
    if(real_shift == 0) return head;
    int pos = n - real_shift;
    struct ListNode* cur = head;
    while(--pos) cur = cur->next;
    last->next = head;
    head = cur->next;
    cur->next = NULL;
    return head;
}
