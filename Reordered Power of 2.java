class Solution {
    static int[][] map = new int[30][10];
    static{
        int cnt=0;
        for(long i=1;i<=1000_000_000;i=i*2) {
            int[] d = digits((int)i);
                for(int j=0;j<=9;j++) map[cnt][j] = d[j];
            cnt++;
        }
    }
    public boolean reorderedPowerOf2(int n) {
        int[] d = digits(n);
        p: for(int i=0;i<30;i++){
            for(int j=0;j<10;j++) if(d[j]!=map[i][j]) continue p;
            return true;
        }
        return false;
    }
    private static int[] digits(int n){
        int[] map = new int[10];
        while(n!=0){
            int d = n%10;
            map[d] = map[d]+1;
            n=n/10;
        }
        return map;
    }
}
