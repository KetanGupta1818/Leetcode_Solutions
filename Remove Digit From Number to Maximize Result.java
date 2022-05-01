import java.math.BigDecimal;
class Solution {
    public String removeDigit(String number, char digit) {
        BigDecimal max = new BigDecimal(0);
        for(int i=0;i<number.length();i++){
            if(number.charAt(i)==digit){
                String left = number.substring(0,i);
                String right = number.substring(i+1);
                String num = left + right;
                BigDecimal numberBD = new BigDecimal(num);
                if(numberBD.compareTo(max)==1)
                    max = numberBD;
            }

        }
        return max.toString();
    }
}
