class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int M=0,P=0,G=0;
        int lastM=0,lastP=0,lastG=0;
        int[] travellingTime = new int[garbage.length];
        for(int i=0;i<garbage.length;i++){
            if(i!=0) travellingTime[i] = travel[i-1]+travellingTime[i-1];
            String g = garbage[i];
            for(int j=0;j<g.length();j++){
                char c = g.charAt(j);
                if(c=='G') {
                    G++;
                    lastG=i;
                }
                else if(c=='M') {
                    M++;
                    lastM=i;
                }
                else {
                    P++;
                    lastP=i;
                }
            }
        }
        return M+P+G+travellingTime[lastG]+travellingTime[lastM]+travellingTime[lastP];
    }
}
