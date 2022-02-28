var subtractProductAndSum = function(n) {
    return Array.from(String(n),Number).reduce((x,y)=>x*y)-Array.from(String(n),Number).reduce((x,y)=>x+y);
};
