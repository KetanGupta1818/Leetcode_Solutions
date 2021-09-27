class Solution {
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> answer = new ArrayList<>();
        for(int row=0;row<=rowIndex;row++) {
        	List<Integer> cur_list = new ArrayList<>();
        	for(int col=0;col<=row;col++) {
        		cur_list.add(pascal(row,col));
        	}
        	answer.add(cur_list);
        }
        return answer.get(rowIndex);
    }
    public static int pascal(int row, int col) {
    	if(row<0 || col<0) return 0;
    	if(row==col || col==0) return 1;
    	else return pascal(row-1,col-1) + pascal(row-1,col);
    }
}
SOLUTION 2/________________
class Solution {
	public static List<Integer> getRow(int rowIndex) {
        List<Integer> cur_list = new ArrayList<>();
        for(int col=0;col<=rowIndex;col++) cur_list.add(pascal(rowIndex,col));
        return cur_list;
    }
        
    
    public static int pascal(int row, int col) {
    	if(row<0 || col<0) return 0;
    	if(row==col || col==0) return 1;
    	else return pascal(row-1,col-1) + pascal(row-1,col);
    }
}
SOLUTION 3
