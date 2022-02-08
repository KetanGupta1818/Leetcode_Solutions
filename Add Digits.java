class Solution {
    public int addDigits(int num) {
        int sum = 0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        if(sum/10<1) return sum;
        return addDigits(sum);
    }
}
