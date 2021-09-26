class Solution {
    public static int[][] merge(int[][] interval) {
        List<List<Integer>> answer = new ArrayList<>();
        int [][] intervals = Sort(interval); //Sort yhe given 2D array on the bases on first element.
        int i;
        for(i=0;i<intervals.length;i++)
        Arrays.sort(intervals[i]);
        for(i=0;i<intervals.length-1;i++) {
        	if(intervals[i][0]<=intervals[i+1][0] && intervals[i][1]>=intervals[i+1][1]) { //Check for subset
        		intervals[i+1][0] = intervals[i][0];
        		intervals[i+1][1] = intervals[i][1];
        	}
        	else if(intervals[i][1]>=intervals[i+1][0]) {
        		intervals[i+1][0] = intervals[i][0];
        	}
        	
        	else {
        		List<Integer> merged_array = new ArrayList<>();
        		merged_array.add(intervals[i][0]);
        		merged_array.add(intervals[i][1]);
        		answer.add(merged_array);
        	}
        }
		List<Integer> merged_array = new ArrayList<>();
		merged_array.add(intervals[i][0]);
		merged_array.add(intervals[i][1]);
		answer.add(merged_array);
		int arr[][] = new int[answer.size()][2];
		for(int j=0;j<answer.size();j++) {
			arr[j][0] = answer.get(j).get(0);
			arr[j][1] = answer.get(j).get(1);
		}
		return arr;
    }
    public static int[][] Sort(int[][] A){ //Insertion sort... It is easier to implement than Quick sort for 2d array. 
    	int i,j,key1,key2;
    	for(i=1;i<A.length;i++) {
    		key1 = A[i][0];
    		key2 = A[i][1];
    		j = i;
    		while(j>0 && A[j-1][0]>key1) {
    			A[j][0] = A[j-1][0];
    			A[j][1] = A[j-1][1];
    			j--;
    		}
    		A[j][0] = key1;
    		A[j][1] = key2;
    	
        }
    	return A;
    }
}
