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
SOLUTION 3//-------------------------------------------------------
class Solution {
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> prev = new ArrayList<>();
		prev.add(1);
		return Pascal(prev, rowIndex);
	}
	public static List<Integer> Pascal(List<Integer> prev, int rowIndex){
		if(rowIndex == prev.size()-1) return prev;
		List<Integer> cur = new ArrayList<>();
		cur.add(1);
		for(int i=0;i<prev.size()-1;i++) cur.add(prev.get(i)+prev.get(i+1));
		cur.add(1);
		return Pascal(cur,rowIndex);
	}
}
