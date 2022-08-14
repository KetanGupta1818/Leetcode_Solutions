class Solution {
    private static final int[] fac = {1,1,2,6,24,120,720,5040,40320,362880};
    public int countSpecialNumbers(int n) {
        List<Integer> d= new ArrayList<>();
        if(n<=10) return n;
        while(n!=0){
            d.add(n%10);
            n=n/10;
        }
        int[] digit = new int[d.size()];
        for(int i=0;i< d.size();i++){
            digit[i] = d.get(d.size()-i-1);
        }
        return nDigitsSpecialNumbers(digit.length-1)+fullLengthSpecialNumbers(digit,0,new HashSet<>(),11);
    }
    private int nDigitsSpecialNumbers(int n){
        if(n == 0) return 0;
        return 9 * fac[9]/fac[10-n] + nDigitsSpecialNumbers(n-1);
    }
    private int fullLengthSpecialNumbers(int[] digit, int index, HashSet<Integer> prevDigits,int prev){
        int nums = 0;
        if(index == digit.length-1){
            for(int i=0;i<=digit[index];i++) if(!prevDigits.contains(i)) nums++;
            return nums;
        }
        for(int i=0;i<digit[index];i++){
            if(i==0 && index==0) continue;
            if(!prevDigits.contains(i)){
                nums += fac[9-prevDigits.size()]/fac[9-prevDigits.size()-digit.length+index+1];
            }
        }
        if(prevDigits.contains(digit[index])) return nums;
        prevDigits.add(digit[index]);
        return nums + fullLengthSpecialNumbers(digit,index+1,prevDigits,digit[index]);
    }
}
