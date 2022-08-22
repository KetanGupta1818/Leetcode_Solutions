class Solution {
    public int validSubarraySize(int[] nums, int threshold){
        int n = nums.length;
        int[] minimumWindow = new int[n];
        for(int i=0;i<n;i++){
            minimumWindow[i] = threshold/nums[i] + 1;
        }
        int[] rightNextGreaterElement = rightNextGreaterElement(minimumWindow);
        int[] leftNextGreaterElement = leftNextGreaterElement(minimumWindow);
        for(int i=0;i<n;i++){
            if(rightNextGreaterElement[i]-leftNextGreaterElement[i]-1>=minimumWindow[i])
                return minimumWindow[i];
        }
        return -1;
    }

    
    private int[] rightNextGreaterElement(int[] arr){
        ArrayDeque<Pair> stack = new ArrayDeque<>();
        int[] nextGreaterElements = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && stack.peek().value<arr[i])
                nextGreaterElements[stack.pop().index] = i;
            stack.push(new Pair(arr[i],i));
        }
        while(!stack.isEmpty()) nextGreaterElements[stack.pop().index] = arr.length;
        return nextGreaterElements;
    }
    private int[] leftNextGreaterElement(int[] arr){
        ArrayDeque<Pair> stack = new ArrayDeque<>();
        int[] nextGreaterElements = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek().value<arr[i])
                nextGreaterElements[stack.pop().index] = i;
            stack.push(new Pair(arr[i],i));
        }
        while(!stack.isEmpty()) nextGreaterElements[stack.pop().index] = -1;
        return nextGreaterElements;
    }
}
class Pair{
    int value;
    int index;

    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
