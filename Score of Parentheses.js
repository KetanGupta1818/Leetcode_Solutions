var scoreOfParentheses = function(s) {
    let stack = [];
    for(let c of s){
        if(c==="(") stack.push("(");
        else{
            let num=0;
            let poppedCharacter = stack.pop();
            if(poppedCharacter==="(") num = 1;
            else{
                num = poppedCharacter*2;
                stack.pop();
            }
            if(typeof(stack[stack.length-1]) === "number") {
                num+=stack.pop();
            }
            stack.push(num);
        }
    }
    return stack.pop();
};
