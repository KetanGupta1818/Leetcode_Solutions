class Solution {
    HashSet<Integer> answer = new HashSet<>();
    public int[] numsSameConsecDiff(int n, int k) {
        for(int i=1;i<=9;i++) rec(Integer.toString(i),1,k,n);
        int[] a = new int[answer.size()];
        int i=0;
        for(int v: answer) a[i++] = v;
        return a;
    }
    private void rec(String num, int index, int k, int n){
        if(index == n){
            answer.add(Integer.parseInt(num));
            return;
        }
        int d = num.charAt(index-1)-'0';
        if(d+k<=9) rec(num+ (d + k),index+1,k,n);
        if(d-k>=0) rec(num + (d-k),index+1,k,n);
    }
}
