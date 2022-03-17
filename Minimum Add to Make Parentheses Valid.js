var minAddToMakeValid = function(s) {
    let answer=0,counter=0;
    for(let c of s){
        if(c==="(") counter++;
        else{
            if(counter==0) answer++;
            else counter--;
        }
    }
    counter=0;
    for(let i=s.length-1;i>=0;i--){
        let c = s.substring(i,i+1);
        if(c===")") counter++;
        else{
            if(counter==0) answer++;
            else counter--;
        }
    }
    return answer;
};
