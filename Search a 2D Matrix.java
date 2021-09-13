class Solution {
	public static boolean searchMatrix(int[][] matrix, int target) {
		int rows = matrix.length;
		if(rows == 0) return false;
		int columns = matrix[0].length;
		int left = 0;
		int right = rows*columns - 1;
		while(left<=right) {
			int mid = (left + right)/2;
			if(matrix[mid/columns][mid%columns] == target) return true;
			else if(matrix[mid/columns][mid%columns] > target) right = mid-1;
			else left = mid+1;
		}
		return false;	
	}
}
