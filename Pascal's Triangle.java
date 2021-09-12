class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> Listans = new ArrayList<List<Integer>>();
        for(int i=0;i<numRows;i++){
            List<Integer> list = new ArrayList<Integer>();
            for(int j=0;j<i+1;j++){
                list.add(pascal(i,j));
            }
            Listans.add(list);
        }
        return Listans;
    }
    public static int pascal(int row, int col){
        if(col==0 || row==col) return 1;
        else return pascal(row-1,col-1) + pascal(row-1,col);
    }
}
