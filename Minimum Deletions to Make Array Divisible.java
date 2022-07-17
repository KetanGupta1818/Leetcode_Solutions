class Solution {
    public static int getGCD(int x, int y){
        int a = Math.max(x,y);
        int b = Math.min(x,y);
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    public static int getGCDOfArray(int[] arr){
        if(arr.length == 1) return arr[0];
        int prevGCD = getGCD(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++) prevGCD = getGCD(prevGCD,arr[i]);
        return prevGCD;
    }
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        int gcd = getGCDOfArray(numsDivide);
        if(gcd < nums[0]) return -1;
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(gcd%num == 0) return i;
        }
        return -1;
    }
}
