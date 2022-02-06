class Solution {
    public long smallestNumber(long num) {
        List<Long> listOfDigits = new ArrayList<>();
        boolean isNegative = num<0;
        num = Math.abs(num);
        while(num>0){
            listOfDigits.add(num%10);
            num/=10;
        }
        long answer=0;
        if(isNegative){
            Collections.sort(listOfDigits,Collections.reverseOrder());
            for(long i: listOfDigits){
                answer = answer*10 + i;
            }
            return answer*(-1);
        }
        else{
            int index = 0;
            Collections.sort(listOfDigits);
            while(index<listOfDigits.size() && listOfDigits.get(index)==0) index++;
            if(index==listOfDigits.size()) return answer;
            answer = answer*10+listOfDigits.get(index);
            for(int i=0;i<index;i++){
                answer = answer*10 + 0;
            }
            index++;
            for(int i=index;i<listOfDigits.size();i++){
                answer = answer*10 + listOfDigits.get(i);
            }
        }
        return answer;
    }
}
