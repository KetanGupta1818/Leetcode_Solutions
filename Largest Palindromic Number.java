class Solution {
    public String largestPalindromic(String num) {
        int largestSingle = -1;
        StringBuilder answer = new StringBuilder();
        int[] map = new int[10];
        for(int i=0;i<num.length();i++) map[num.charAt(i)-'0']++;
        for(int d=9;d>=0;d--){
            if(map[d]%2==1 && largestSingle==-1) largestSingle=d;
            if(d==0 && largestSingle==-1) largestSingle=d;
            if(d==0 && answer.isEmpty()) continue;
            for(int i=0;i<map[d]/2;i++) answer.append(d);
        }
        StringBuilder next = new StringBuilder(answer);
        if(largestSingle!=-1) answer.append(largestSingle);
        answer.append(next.reverse());
        return answer.toString();
    }
}
