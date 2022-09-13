class Solution {
    public boolean validUtf8(int[] data) {
        List<String> list = new ArrayList<>();
        int n = data.length;
        for(int d: data){
            String s = Integer.toBinaryString(d);
            list.add("0".repeat(8-s.length())+s);
        }
        for(int i=0;i<n;i++){
            if(i<=n-4 && isValid4Byte(list.get(i),list.get(i+1),list.get(i+2),list.get(i+3))) i=i+3;
            else if(i<=n-3 && isValid3Byte(list.get(i),list.get(i+1),list.get(i+2))) i=i+2;
            else if(i<=n-2 && isValid2Byte(list.get(i),list.get(i+1))) i++;
            else if(!isValid1Byte(list.get(i))) return false;
        }
        return true;
    }
    private boolean isValid4Byte(String first, String second, String third, String fourth){
        return first.startsWith("11110") && second.startsWith("10") && third.startsWith("10") && fourth.startsWith("10");
    }
    private boolean isValid3Byte(String first, String second, String third){
        return first.startsWith("1110") && second.startsWith("10") && third.startsWith("10");
    }
    private boolean isValid2Byte(String first, String second){
        return first.startsWith("110") && second.startsWith("10");
    }
    private boolean isValid1Byte(String first){
        return first.startsWith("0");
    }
}
