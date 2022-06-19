class Solution {
    public int minimumNumbers(int num, int k) {
        if(num==0) return 0;
        if(num<k) return -1;
        if(num==k) return 1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<=10;i++){
            int d = (i*k)%10;
            if(!map.containsKey(d)) map.put(d,i);
        }
        int x = -1;
        if(map.containsKey(num%10)) x = map.get(num%10);
        if(x == -1) return x;
        if(x*k>num) return -1;
        return x;
    }
}
