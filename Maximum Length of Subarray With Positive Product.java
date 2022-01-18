class Solution {
    public int getMaxLen(int[] nums) {
        int negativeNumbers = 0, length = 0, maxLength = 0, lastNegativeNumber = 0, firstNegativeNumber = 0;
        for(int num: nums){
            if(num>0) length++;
            else if(num<0) {
                negativeNumbers++;

                length++;
                if(negativeNumbers==1) firstNegativeNumber=length;
                lastNegativeNumber = length;

            }
            else{
                if(negativeNumbers%2==1){
                    int length1 = Math.max(lastNegativeNumber-1,length-lastNegativeNumber);
                    length = Math.max(Math.max(length1,length-firstNegativeNumber),firstNegativeNumber-1);
                }
                maxLength = Math.max(maxLength,length);
                length = 0; negativeNumbers = 0;
            }
        }
        if(length!=0 || negativeNumbers!=0){
            if(negativeNumbers%2==1){
                int length1 = Math.max(lastNegativeNumber-1,length-lastNegativeNumber);
                length = Math.max(Math.max(length1,length-firstNegativeNumber),firstNegativeNumber-1);
            }
            maxLength = Math.max(maxLength,length);
        }
        return maxLength;
    }
}
