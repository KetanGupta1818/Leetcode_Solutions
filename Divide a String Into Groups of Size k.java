class Solution {
    public String[] divideString(String s, int k, char fill) {
        
        int size = 0;
        int n = s.length();
        int r = n%k;
        if(r==0) size = n/k;
        else size = n/k+1;
        String[] ans = new String[size];
        int i=0;
        for(i=0;i<n/k;i++){
            ans[i] = s.substring(i*k,(i+1)*k);
        }
        if(r!=0){
            String l = s.substring(i*(k));
            while(l.length()<k) l = l + fill;
            ans[i] = l;
        }
        return ans;
    }
}
