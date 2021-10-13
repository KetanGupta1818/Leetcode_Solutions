class Solution {
    public static boolean squareIsWhite(String coordinates) {
        int n1 = coordinates.charAt(1) - 'a';
        int n2 = coordinates.charAt(0) - '1';
        if(Math.abs(n2-n1)%2==0) return false;
        return true;
    }
}
