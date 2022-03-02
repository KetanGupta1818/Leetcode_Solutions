var arraySign = function(nums) {
    if(nums.indexOf(0)!=-1) return 0;
    return nums.filter(num=>num<0).length%2===0?1:-1;
};
