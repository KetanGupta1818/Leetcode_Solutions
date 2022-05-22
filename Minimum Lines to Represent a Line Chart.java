import java.math.BigDecimal;
class Solution {
    public int minimumLines(int[][] stockPrices) {
        int n = stockPrices.length,lines=1;
        if(n<3) return n-1;
        Arrays.sort(stockPrices, Comparator.comparingInt(a -> a[0]));
        for(int i=1;i<n-1;i++){
            BigDecimal x1 = BigDecimal.valueOf(stockPrices[i-1][0]), x2 = BigDecimal.valueOf(stockPrices[i][0]), x3 = BigDecimal.valueOf(stockPrices[i+1][0]);
            BigDecimal y1 = BigDecimal.valueOf(stockPrices[i-1][1]), y2 = BigDecimal.valueOf(stockPrices[i][1]), y3 = BigDecimal.valueOf(stockPrices[i+1][1]);
            BigDecimal d1 = (x2.subtract(x1)).multiply(y3.subtract(y2));
            BigDecimal d2 = (y2.subtract(y1)).multiply(x3.subtract(x2));
            if(!d1.equals(d2)) lines++;
        }
        return lines;
    }
}
