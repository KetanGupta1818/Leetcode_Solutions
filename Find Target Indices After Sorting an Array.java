class Solution {
        public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        int[] sortedArray = Arrays.stream(nums).sorted().toArray();
        int index = binarySearch(sortedArray,target,0,sortedArray.length-1);
        if(index==-1) return list;
        for(int i=index;i>=0;i--) {
            if (sortedArray[i] == target) list.add(i);
            else break;
        }
        for(int i=index+1;i<sortedArray.length;i++){
            if(sortedArray[i]==target) list.add(i);
            else break;
        }
        Collections.sort(list);
        return list;
    }
    public int binarySearch(int[] arr, int target,int left, int right){
        if(right<left) return -1;
        int mid = left + (right - left)/2;
        if(arr[mid]>target) return binarySearch(arr,target,left,mid-1);
        else if(arr[mid]<target) return binarySearch(arr,target,mid+1,right);
        else return mid;
    }
}
