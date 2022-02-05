class Solution {
    public int minimumSum(int num) {
        List<Integer> list = new ArrayList<>();
        while(num>0){
            int d = num%10;
            if(d!=0) list.add(d);
            num/=10;
        }
        if(list.size()==1)  return list.get(0);
        if(list.size()==2) return list.get(0)+list.get(1);
        Collections.sort(list);
        if(list.size()==3){
            return 10*list.get(0)+list.get(1)+list.get(2);
        }
        return 10*list.get(0)+list.get(3) + 10*list.get(1)+list.get(2);
    }
}
