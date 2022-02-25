class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int[] num1 = new int[v1.length];
        int[] num2 = new int[v2.length];
        int index1 = 0;
        int index2 = 0;
        for(String string: v1){
            int num = 0;
            int sIndex = 0;
            while(sIndex<string.length() && string.charAt(sIndex)=='0') sIndex++;

            while(sIndex<string.length()){
                num=num*10+(string.charAt(sIndex++)-'0');
            }
            num1[index1++] = num;
        }
        for(String string: v2){
            int num = 0;
            int sIndex = 0;
            while(sIndex<string.length() && string.charAt(sIndex)=='0') sIndex++;

            while(sIndex<string.length()){
                num=num*10+(string.charAt(sIndex++)-'0');
            }
            num2[index2++] = num;
        }
        index1= 0;
        index2 = 0;
        while(index1<num1.length && index2<num2.length){
            if(num1[index1]<num2[index2]) return -1;
            else if(num1[index1] > num2[index2]) return 1;
            else {
                index1++;
                index2++;
            }
        }
        while(index1<num1.length) if(num1[index1++]>0) return 1;
        while(index2<num2.length) if(num2[index2++]>0) return -1;
        return 0;
    }
}
