/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var minimalKSum = function(nums, k) {
    nums.sort((a,b)=>a-b);
    let sum = (k*(k+1))/2;
    let i=0,add=0;
    while(k+add>=nums[i]){
        if(i!=0 && nums[i]===nums[i-1]) {i++; continue;}
        add++;
        sum-=nums[i];
        sum=sum+k+add;
        i++;
    }
    return sum;
};
