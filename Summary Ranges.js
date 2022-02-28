var summaryRanges = function(nums) {
    let start=0;let end=0;
    let arrString = [];
    for(let i=0;i<nums.length-1;i++){
	    if(nums[i]+1===nums[i+1]) end++;
	    else{
		if(start==end) arrString.push(""+nums[start]);
		else arrString.push(nums[start]+"->"+nums[end]);
		start=++end;
	    }
    }
    if(nums.length==0)return arrString; 
    if(start==end) arrString.push(""+nums[start]);
    else arrString.push(nums[start]+"->"+nums[end]);
    return arrString;
};
