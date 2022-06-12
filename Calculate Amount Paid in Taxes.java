
import java.math.BigDecimal;
import java.math.RoundingMode;
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0d;int index=0;
        while(income>0){
            int range = brackets[index][0] - ((index==0)?0:brackets[index-1][0]);
            int rate = brackets[index][1];
            int amountLeft = (income>=range)?range:income;
            income= income - range;
            tax += ((amountLeft)*(double)rate)/100;
            index++;
        }
        BigDecimal bd = new BigDecimal(tax).setScale(5, RoundingMode.HALF_DOWN);
        return Double.parseDouble(bd.toString());
    }
}
