class Solution {
    public static int findTheWinner(int n, int k) {
        if(k==1 || n==1) return n;
        int counter = 0;
        Queue<Integer> Q = new LinkedList<>();
        for(int i=0;i<n;i++) {
        	if(counter == (k-1)) counter = 0;
        	else {
        		Q.add(i+1);
        		counter++;
        	}
        }
        while(Q.size()>1) {
        	if(counter == (k-1)) {
        		counter = 0;
        		Q.remove();
        	}
        	else {
        		Q.add(Q.remove());
        		counter++;
        	}
        }
        return Q.remove();
    }
}
