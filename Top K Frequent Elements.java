class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
    	int[] answer = new int[k];
    	Arrays.sort(nums);
    	HashMap<Integer, List<Integer>> hm = new HashMap<>();
    	List<Integer> frequency = new ArrayList<>();
    	int count = 1;
    	for(int i=1;i<nums.length;i++) {
    		if(nums[i-1]==nums[i]) count++;
    		else {
    			frequency.add(count);
    			if(hm.containsKey(count)) {
    				List<Integer> list = hm.get(count);
    				list.add(nums[i-1]);
    				hm.put(count, list);
    			}
    			else {
    				List<Integer> list = new ArrayList<>();
    				list.add(nums[i-1]);
    				hm.put(count, list);
    			}
    			count = 1;
    		}
    	}
    	if(count == 1) {
    		if(hm.containsKey(count)){
				List<Integer> list = hm.get(count);
				list.add(nums[nums.length-1]);
				hm.put(count, list);
			}
    		else {
				List<Integer> list = new ArrayList<>();
				list.add(nums[nums.length-1]);
				hm.put(count, list);
			}
    		frequency.add(count);
    	}
    	else {
    		if(hm.containsKey(count)){
				List<Integer> list = hm.get(count);
				list.add(nums[nums.length-1]);
				hm.put(count, list);
			}
    		else {
				List<Integer> list = new ArrayList<>();
				list.add(nums[nums.length-1]);
				hm.put(count, list);
			}
    		frequency.add(count);
    	}
    	Collections.sort(frequency,Collections.reverseOrder());
    	int size = 0;
    	List<Integer> ans = new ArrayList<>();
    	while(size!=k) {
    		int f = frequency.get(size);
    		List<Integer> list = hm.get(f);
    		ans.addAll(list);
    		size = size + list.size();
    		
    	}
    	for(int i=0;i<k;i++) answer[i]=ans.get(i);
    	return answer;
    }
}
