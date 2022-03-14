var simplifyPath = function(path) {
    let arr = path.split("/");
    let stack = [];
    for(let s of arr){
	    if(s==="..") stack.pop();
	    else if(s==='.' || s.length===0) continue;
	    else stack.push(s);
    }
    let answer = "";
    for(let s of stack) answer+="/"+s;
    return answer!==""?answer:"/";
};
