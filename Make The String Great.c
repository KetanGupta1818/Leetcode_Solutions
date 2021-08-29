#include<ctype.h>
char * makeGood(char * s){
    int top = -1;
    char *ns = (char*)malloc(strlen(s)*sizeof(s));
    for(int i=0;i<strlen(s);i++){
        if(top == -1){
            ns[++top] = s[i];
            continue;
        }
        if((ns[top]!=s[i]) && (toupper(ns[top])==s[i] || tolower(ns[top])==s[i])){
            top--;
            continue;
        }
        else{
            ns[++top] = s[i];
        }
    }
    ns[top+1] = '\0';
    return ns;
}
