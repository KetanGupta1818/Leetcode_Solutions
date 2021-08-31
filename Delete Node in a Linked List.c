void deleteNode(struct ListNode* node) {
    struct ListNode *temp1 = node->next;
    node->val = temp1->val;
    node->next = temp1->next;
    free(temp1);
}
