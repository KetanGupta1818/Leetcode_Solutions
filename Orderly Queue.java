class Solution {
    public String orderlyQueue(String s, int k) {
        if(k == 1){
            String answer = s;
            for(int i=0;i<s.length();i++){
                String temp = s.substring(i) + s.substring(0,i);
                if(temp.compareTo(answer)<0) answer = temp;
            }
            return answer;
        }
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
}
