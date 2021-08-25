/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

//There will be two pointers temp1 and temp2. temp1 will start moving only when temp2 has made n moves forward
struct ListNode* removeNthFromEnd(struct ListNode* head, int n){
    if(head->next == NULL && n==1) return NULL;  //Number of Nodes is 1
    struct ListNode *temp1 = head;
    struct ListNode *temp2 = head;
    while(n){
        temp2 = temp2->next;
        n--;
    }
    if(temp2 == NULL){ //We need to delete the first term
       struct ListNode *ptr = temp1;
        ptr = ptr->next;
        free(temp1);
        return ptr; 
    } 
    while(temp2->next != NULL){
        temp1 = temp1->next; 
        temp2 = temp2->next;
    }
    struct ListNode *ptr = temp1;
    ptr = ptr->next;
    temp1->next = ptr->next;
    free(ptr);
    return head;
}
