var canMakeArithmeticProgression = function(arr) {
    arr.sort((a,b)=>a-b);
    let dif = arr[1]-arr[0];
    for(let i=1;i<arr.length-1;i++) if(arr[i+1]-arr[i]!==dif) return false;
    return true;
};
