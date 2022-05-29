/*  
    Step 1:
        If word does not start with $ append it to answer
        Else consider for discount evaluation
    
    Step 2:
        Let language library function check if the string after $ is a valid decimal number or not
        If its a valid number calculate the discounted amount
        
    Step 3:
        Round of the calculated amount.

*/
import java.math.BigDecimal;
import java.math.RoundingMode;
class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        StringBuilder answer = new StringBuilder();
        for(String word: words){
            if(word.charAt(0)!='$') answer.append(word).append(" ");
            else{
                double amt;
                try{
                    amt = Double.parseDouble(word.substring(1));
                }
                catch (Exception e){
                    answer.append(word).append(" ");
                    continue;
                }
                double val = amt - amt*0.01*discount;
                BigDecimal bd = new BigDecimal(Double.toString(val));
                bd = bd.setScale(2, RoundingMode.HALF_UP);
                answer.append("$").append(bd).append(" ");
            }
        }
        return answer.substring(0,answer.length()-1).toString();
    }
}
