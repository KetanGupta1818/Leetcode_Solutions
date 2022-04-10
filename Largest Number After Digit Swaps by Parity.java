class Solution {
    public int largestInteger(int num) {
        List<Integer> listEven = new ArrayList<>();
        List<Integer> listOdd = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();
        int n = num;
        while(n>0){
            if((n%10)%2==0){
                listEven.add(n%10);
            }
            else listOdd.add(n%10);
            numberList.add(n%10);
            n/=10;
        }
        listEven.sort(Collections.reverseOrder());
        listOdd.sort(Collections.reverseOrder());
        Collections.reverse(numberList);
        int ei = 0;
        int oi = 0;
        int answer = 0;
        for(int d: numberList){
            if(d%2==0) answer = answer*10 + listEven.get(ei++);
            else answer = answer*10 + listOdd.get(oi++);
        }
        System.out.println(numberList);
        return answer;
    }
}
