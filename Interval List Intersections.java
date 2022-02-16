class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<List<Integer>> answer = new ArrayList<>();
        int indexA = 0;
        int indexB = 0;
        while(indexA<A.length && indexB<B.length){
            if(A[indexA][0]<=B[indexB][0]){
                if(A[indexA][1]>=B[indexB][0] && A[indexA][1]<=B[indexB][1]){
                    answer.add(Arrays.asList(B[indexB][0],A[indexA][1]));
                    indexA++;
                }
                else if(A[indexA][1]>=B[indexB][0] && A[indexA][1]>=B[indexB][1]){
                    answer.add(Arrays.asList(B[indexB][0],B[indexB][1]));
                    indexB++;
                }
                else indexA++;
            }
            else{
                if(B[indexB][1]>=A[indexA][0] && B[indexB][1]<=A[indexA][1]){
                    answer.add(Arrays.asList(A[indexA][0],B[indexB][1]));
                    indexB++;
                }
                else if(B[indexB][1]>=A[indexA][0] && B[indexB][1]>=A[indexA][1]){
                    answer.add(Arrays.asList(A[indexA][0],A[indexA][1]));
                    indexA++;
                }
                else indexB++;
            }
        }
        //System.out.println(answer);
        int[][] ans = new int[answer.size()][2];
        for(int i=0;i<ans.length;i++){
            ans[i][0] = answer.get(i).get(0);
            ans[i][1] = answer.get(i).get(1);
        }
        return ans;
    }
}
