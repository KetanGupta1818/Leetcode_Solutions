
struct ListNode* oddEvenList(struct ListNode* head){
    if(head==NULL || head->next==NULL) return head;
    struct ListNode* cur = head;
    struct ListNode* head1 = malloc(sizeof(struct ListNode));
    head1->next = NULL;
    struct ListNode* ptr = head1;
    while(cur!=NULL && cur->next!=NULL){
        struct ListNode* temp = cur->next;
        cur->next = temp->next;
        temp->next = NULL;
        ptr->next = temp;
        ptr = temp;
        if(cur->next!=NULL) cur = cur->next;
    }
    cur->next = head1->next;
    return head;
}
