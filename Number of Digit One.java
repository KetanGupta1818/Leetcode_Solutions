class Solution {
    int[] arr = new int[10];
    public int countDigitOne(int n) {
        String num = Integer.toString(n);
        arr[0] = 1;
        for(int i=1;i< arr.length;i++)
            arr[i] = (int)Math.pow(10,i) + arr[i-1]*10;
        return fun(num);
    }
    public int fun(String num){
        if(num.length()==1) {
            if(num.charAt(0)=='0') return 0;
            else return 1;
        }
        int curDigit = num.charAt(0) - '0';
        if(curDigit==0) return fun(num.substring(1));
        int ones = (curDigit-1)*arr[num.length()-2];
        if(curDigit!=1) ones+=(int)Math.pow(10,num.length()-1);
        else ones+=Integer.parseInt(num.substring(1))+1;
                ones+=arr[num.length()-2];
        return ones+fun(num.substring(1));
    }
}
