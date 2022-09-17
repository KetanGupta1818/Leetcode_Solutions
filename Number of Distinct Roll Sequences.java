class Solution {
    private static final int MOD = 1_000_000_007;
    public int distinctSequences(int n){
        if(n==1) return 6;
        if(n==2) return 22;
        long[][] matrixOld = {{0,0,0,0,0,0,0},{5,0,1,1,1,1,1},{3,1,0,1,0,1,0},{4,1,1,0,1,1,0},{3,1,0,1,0,1,0},{5,1,1,1,1,0,1},{2,1,0,0,0,1,0}};
        for(int num=3;num<=n;num++){
            long[][] matrixNew = new long[7][7];
            for(int firstNumber=1;firstNumber<=6;firstNumber++){
                for(int secondNumber=1;secondNumber<=6;secondNumber++){
                    if(firstNumber==secondNumber || getGCD(firstNumber,secondNumber)!=1) continue;
                    matrixNew[firstNumber][secondNumber] = Math.floorMod(matrixOld[secondNumber][0] - matrixOld[secondNumber][firstNumber],MOD);
                }
            }
            for(int i=1;i<=6;i++){
                for(int j=1;j<=6;j++) matrixNew[i][0] = (matrixNew[i][0]+matrixNew[i][j])%MOD;
            }
            matrixOld = matrixNew;
        }
        return (int)((matrixOld[1][0] + matrixOld[2][0] +matrixOld[3][0] +matrixOld[4][0] +matrixOld[5][0] +matrixOld[6][0])%MOD);
    }
    public static int getGCD(int x, int y){
        int a = Math.max(x,y);
        int b = Math.min(x,y);
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}
