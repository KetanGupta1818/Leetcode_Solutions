class Solution {
    public int nextGreaterElement(int n) {
        int[] digits = getDigits(n);
        int index = digits.length-1;
        while(index>0 && digits[index]<=digits[index-1]) index--;
        if(index == 0) return -1;
        long nextValue = 0L;
        for(int i=0;i<index-1;i++) nextValue = nextValue*10L + digits[i];
        int indexOfNextGreaterElement = getIndexOfNextGreaterElement(digits[index-1],digits,index);
        nextValue = nextValue*10L + digits[indexOfNextGreaterElement];
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i=index-1;i<digits.length;i++){
            if(i == indexOfNextGreaterElement) continue;
            queue.offer(digits[i]);
        }
        while(!queue.isEmpty()) nextValue = nextValue*10L + queue.remove();
        if(nextValue>Integer.MAX_VALUE) return -1;
        return (int)nextValue;
        
    }
    private int[] getDigits(int n){
        List<Integer> reverseDigits = new ArrayList<>();
        while(n>0){
            reverseDigits.add(n%10);
            n = n/10;
        }
        int[] digits = new int[reverseDigits.size()];
        for(int i=0;i<reverseDigits.size();i++)
            digits[i] = reverseDigits.get(reverseDigits.size()-1-i);
        return digits;
    }
    private int getIndexOfNextGreaterElement(int element, int[] digits, int start){
        if(start == digits.length) return start-1;
        if(start == digits.length-1) return start;
        int nextGreaterElement = 10;
        int index = -1;
        for(int i=start;i<digits.length;i++){
            if(digits[i]>element && digits[i]<nextGreaterElement){
                nextGreaterElement = digits[i];
                index = i;
            }
        }
        return index;
    }
}
