var validPalindrome = function(s) {
    if(checkPalindrome(s)) return true;
    for(let i=0;i<s.length/2;i++){
        if(s.charAt(i)!=s.charAt(s.length-1-i))
            return checkPalindrome(s.substring(0,i)+s.substring(i+1)) || 
                checkPalindrome(s.substring(0,s.length-1-i)+s.substring(s.length-i));
    }
};
var checkPalindrome = function(s){
    for(let i=0;i<s.length/2;i++){
        if(s.charAt(i)!=s.charAt(s.length-1-i)) return false;
    }
    return true;
}
