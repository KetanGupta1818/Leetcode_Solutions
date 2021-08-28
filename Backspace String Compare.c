#include<stdio.h>
#include<stdlib.h>
#include<string.h>
struct stack{
    int capacity;
    int top;
    char *arr;
};
struct stack* CreateStack(int capacity){
    struct stack *S = malloc(sizeof(struct stack));
    S->capacity = capacity;
    S->top = -1;
    S->arr = malloc(S->capacity*sizeof(char));
    return S;
}
int isFull(struct stack *S){
    return (S->top == S->capacity-1);
}
int isEmpty(struct stack *S){
    return (S->top == -1);
}
void DoubleStack(struct stack *S){
    S->capacity*=2;
    S->arr = realloc(S->arr,S->capacity*sizeof(char));
}
void push(struct stack *S, char data){
    if(isFull(S)) DoubleStack(S);
    S->arr[++S->top] = data;   
}
char pop(struct stack *S){
    if(isEmpty(S)){
        printf("Error\n");
        return '\0';
    }
    return S->arr[S->top--];
}
char peek(struct stack *S){
    if(isEmpty(S)){
        printf("The stack is empty\n");
        return '\0';
    }
    return S->arr[S->top];
}
//Driver Function
bool backspaceCompare(char * s, char * t){
    int n1 = strlen(s);
    int n2 = strlen(t);
    char x;
    struct stack *stk1 = CreateStack(n1);
    struct stack *stk2 = CreateStack(n2);
    for(int i=0;i<n1;i++){
        if(s[i]=='#' && !isEmpty(stk1)) x = pop(stk1);
        else if(s[i]!='#') push(stk1, s[i]);
        else continue;
    }
    int j =0;
    for(j=0;j<n2;j++){
        if(t[j]=='#' && !isEmpty(stk2)) x = pop(stk2);
        else if(t[j]!='#') push(stk2, t[j]);
        else continue;
    }
    if(isEmpty(stk1) && isEmpty(stk2)) return true;
    while(!isEmpty(stk1) && !isEmpty(stk2)){
        if(pop(stk1) == pop(stk2)) continue;
        else return false;
    }
    if(isEmpty(stk1) && isEmpty(stk2)) return true;
    return false;    
}
