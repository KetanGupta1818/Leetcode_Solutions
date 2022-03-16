/**
 * @param {number[]} pushed
 * @param {number[]} popped
 * @return {boolean}
 */
var validateStackSequences = function(pushed, popped) {
    let n = pushed.length;
    let stack = [];
    let i=0,j=0;
    while(i<n){
        if(pushed[i]===popped[j]){
            i++;j++
        }
        else if(stack.length!==0 && stack[stack.length-1]===popped[j]){
            j++;
            stack.pop();
        }
        else{
            stack.push(pushed[i]);
            i++
        }
    }
    while(j<n){
        if(stack[stack.length-1]!==popped[j]) return false;
        j++;
        stack.pop();
    }
    return true;
};
