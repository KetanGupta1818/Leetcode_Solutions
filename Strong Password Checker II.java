class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if(password.length()<8) return false;
        boolean lower=false,upper=false,digit=false,special=false;
        String s = "!@#$%^&*()-+";
        char prev = password.charAt(0);
        for(int i=0;i<password.length();i++){
            char cur = password.charAt(i);
            if(Character.isUpperCase(cur)) upper = true;
            if(Character.isLowerCase(cur)) lower = true;
            if(Character.isDigit(cur)) digit = true;
            if(s.contains(String.valueOf(cur))) special = true;
            if(i!=0 && prev==cur) return false;
            prev = cur;
        }
        return lower && upper && digit && special;
    }
}
