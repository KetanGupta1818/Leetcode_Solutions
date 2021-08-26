struct ListNode* deleteDuplicates(struct ListNode* head){
    if(head == NULL) return head; //0 node
    if(head->next == NULL) return head; //! node
    struct ListNode *temp1 = head;
    struct ListNode *temp2 = head->next;
    while(temp2!=NULL){
        if(temp1->val == temp2->val){
            struct ListNode *del = temp2;
            temp2 = temp2->next;
            temp1->next = temp2;
            free(del);
        }
        else{
            temp1 = temp1->next;
            temp2 = temp2->next;
        }
    }
    return head;
}
