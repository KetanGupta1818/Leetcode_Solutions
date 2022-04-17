class Solution {
    public String digitSum(String s, int k) {
        int i = 0;
        if(s.length()<=k) return s;
        String answer = "";
        while(i<100){
            i++;
            if(formString(s,k).length()<=k){
                answer = formString(s,k);
                return answer;
            }
            s = formString(s,k);
        }
        return answer;
    }
    public String formString(String s, int k){
        int times = 0;
        StringBuilder str = new StringBuilder();
        while(k*times<s.length()){
            String cur = s.substring(k*times,Math.min(k*(times+1),s.length()));
            int sum = 0;
            for(int i=0;i<cur.length();i++){
                sum += (cur.charAt(i)-'0');
            }
            str.append(Integer.toString(sum));
            times++;
        }
        return str.toString();
    }
}
