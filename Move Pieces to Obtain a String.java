class Solution {
    public boolean canChange(String start, String target) {
        if(!same(start,target)) return false;
        int left=0,right=0;
        for(int i=0,j=0;i<start.length();i++,j++){
            char s = start.charAt(i);
            char t = target.charAt(j);
            if(s == 'R') right++;
            if(s == 'L') left--;
            if(left!=0 && right!=0) return false;
            if(t == 'R') right--;
            if(t == 'L') left++;
            if(left == -1 || right == -1) return false;
            if(left >0 && right >0) return false;
        }
        return true;
    }
    private boolean same(String a, String b){
        int aLefts=0,aRights=0,aDash=0;
        int bLefts=0,bRights=0,bDash=0;
        for(int i=0;i<a.length();i++){
            char A = a.charAt(i);
            char B = b.charAt(i);
            if(A == 'L') aLefts++;
            else if(A == 'R') aRights++;
            else aDash++;
            if(B == 'L') bLefts++;
            else if(B == 'R') bRights++;
            else bDash++;
        }
        return (aLefts==bLefts) && aRights==bRights && aDash==bDash;
    }
}
