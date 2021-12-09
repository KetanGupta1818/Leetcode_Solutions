class Solution {
        public boolean canReach(int[] arr, int start) {
        Queue<Integer> indices = new ArrayDeque<>();
        boolean[] visitedIndex = new boolean[arr.length];
        indices.offer(start);
        while(!indices.isEmpty()){
            int currentIndex = indices.poll();
            if(visitedIndex[currentIndex]) continue;
            visitedIndex[currentIndex] = true;
            if(arr[currentIndex]==0) return true;
            int aheadIndex = currentIndex + arr[currentIndex];
            int behindIndex = currentIndex - arr[currentIndex];
            if(aheadIndex<arr.length && !visitedIndex[aheadIndex]) indices.offer(aheadIndex);
            if(behindIndex>=0 && !visitedIndex[behindIndex]) indices.offer(behindIndex);
        }
        return false;
    }
}

//Recursion: 
class Solution {
    public boolean canReach(int[] arr, int start) {
        if(start>=arr.length || start<0 || arr[start]==-1) return false;
        if(arr[start] == 0) return true;
        int val = arr[start];
        arr[start] = -1;
        return canReach(arr,v + start) || canReach(arr,start-v); 
    }
}
