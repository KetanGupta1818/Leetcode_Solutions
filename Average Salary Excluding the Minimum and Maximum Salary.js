var average = function(salary) {
    let maxSalary = salary.reduce((x,y)=>x>y?x:y);
    let minSalary = salary.reduce((x,y)=>x<y?x:y);
    let len = 0;
    return salary.filter(s=>s!==maxSalary && s!==minSalary).reduce((x,y)=>{len++;return x+y;},0)/len;
};
