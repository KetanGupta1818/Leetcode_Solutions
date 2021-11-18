class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[nums.length + 1];
        for(int ele: nums) arr[ele] = 1;
        for(int i=1; i<arr.length; i++) if(arr[i]==0) list.add(i);
        return list;
    }
}
