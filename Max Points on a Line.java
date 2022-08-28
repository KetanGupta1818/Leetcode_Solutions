class Solution {
    public int maxPoints(int[][] points) {
        int max = 0;
        for(int i=0;i<points.length;i++){
            HashMap<Double,Integer> freq = new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(i==j) continue;
                double slope = getSlope(points[i][0],points[i][1],points[j][0],points[j][1]);
                freq.put(slope,freq.getOrDefault(slope,0)+1);
                max = Math.max(max,freq.get(slope));
            }
        }
        return max+1;
    }
    private double getSlope(double x1, double y1, double x2, double y2){
        return (y2-y1)/(x2-x1);
    }
}
