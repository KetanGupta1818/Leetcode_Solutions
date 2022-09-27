class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] s = dominoes.toCharArray();
        int[] l = new int[n];       //left_score  
        int[] r = new int[n];       //right_score
        boolean ra=false,la=false;  //la->left_active, ra->raight_active
        for(int i=0;i<n;i++){
            char c = s[i];
            if(c=='L') ra=false;
            else if(c=='R') ra=true;
            else if(ra){
                r[i] = r[i-1]+1;
            }
        }
        for(int i=n-1;i>=0;i--){
            char c = s[i];
            if(c=='R') la=false;
            else if(c=='L') la=true;
            else if(la) l[i] = l[i+1]+1;
        }
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<n;i++){
            char c = s[i];
            if(c=='L' || c=='R') answer.append(c);
            else{
                if(l[i]==r[i]) answer.append('.');
                else if(l[i]==0) answer.append('R');
                else if(r[i]==0) answer.append('L');
                else if(l[i]<r[i]) answer.append('L');
                else answer.append('R');
            }
        }
        return answer.toString();
    }
}
