class Solution {
    private static int MOD = 1_000_000_007;
    public int maxProfit(int[] inventory, int orders) {
        long answer = 0L;
        int n = inventory.length;
        Arrays.sort(inventory);
        int cur = inventory[n-1];
        for(int i=n-1;i>=1;i--){
            if(inventory[i-1] == cur) continue;
            long size = n-i;
            long curOrders = size*(cur-inventory[i-1]);
            if(curOrders>=orders) curOrders = orders;
            orders = orders-(int)curOrders;
            answer = (answer + fun(curOrders,size,cur))%MOD;
            if(orders==0) break;
            cur =inventory[i-1];
        }
        if(orders>0){
            answer = (answer + fun(orders,n,inventory[0]))%MOD;
        }
        return (int)answer;
    }
    private long fun(long orders, long size, long start){
        long rep = orders/size;
        long sum =(size*(start*(start+1)/2 - (start-rep)*(start-rep+1)/2))%MOD;
        long rem = orders%size;
        start -= rep;
        sum = (sum+start*rem)%MOD;
        return sum;
    }
}
