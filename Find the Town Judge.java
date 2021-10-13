//Complex solutionclass Solution {
    public static int findJudge(int n, int[][] trust) {
        HashSet<Integer> hs = new HashSet<>();
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        for(int i=1;i<=n;i++) hs.add(i);
        for(int i=0;i<trust.length;i++) {
        	if(hs.contains(trust[i][0])) hs.remove(trust[i][0]);
        	if(!hm.containsKey(trust[i][0])) {
        		HashSet<Integer> set = new HashSet<>();
        		set.add(trust[i][1]);
        		hm.put(trust[i][0], set);
        	}
        	else {
        		HashSet<Integer> set = hm.get(trust[i][0]);
        		set.add(trust[i][1]);
        		hm.put(trust[i][0], set);
        	}
        }
        if(hs.size()!=1) return -1;
        System.out.println(hs);
        Object[] arr = hs.toArray();
        int l = (int) arr[0];
        for(int i=1;i<=n;i++) {
        	if(i==l) continue;
        	if(!hm.containsKey(i)) return -1;
        	HashSet<Integer> set = hm.get(i);
        	if(!set.contains(l)) return -1;
        }
        return l;

    }
}
//Simple solution
class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1) return n;
        int[] count = new int[n+1];
        for(int i=0;i<trust.length;i++){
            count[trust[i][1]]++;
            count[trust[i][0]]--;
        }
        for(int i=0;i<n+1;i++){
            if(count[i]==n-1) return i;
        }
        return -1;
    }
}
//The indegree - outdegree == n-1 for the judge
