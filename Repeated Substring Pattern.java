class Solution {
    public boolean repeatedSubstringPattern(String s) {
        StringHash sh = new StringHash(s);
        p: for(int size=1;size<=s.length()/2;size++){
            if(s.length()%size!=0) continue;
            long h = sh.getHashOfSubstringInclusive(0,size-1);
            for(int i=size;i<s.length();i+=size)
                if(h!=sh.getHashOfSubstringInclusive(i,size+i-1)) continue p;
            return true;
        }
        return false;
        
    }

}
class StringHash{
    private static final long A = 911382323L;
    private static final long B = 972663749L;
    private final long[] hash;
    private final long[] powersOfA;

    public StringHash(String s){
        this.hash = new long[s.length()];
        this.powersOfA = new long[s.length()];
        hash[0] = (long)s.charAt(0);
        powersOfA[0] = 1L;
        for(int i=1;i<s.length();i++){
            hash[i] = (hash[i-1]*A + (long)s.charAt(i))%B;
            powersOfA[i] = (powersOfA[i-1]*A)%B;
        }
    }
    public long getHashOfSubstringInclusive(int left, int right){
        if(left<0 || right>=powersOfA.length){
            System.out.println("Index out bounds for substring [" + left + " ," +right+"]");
            return -1L;
        }
        if(left == 0) return this.hash[right];
        return Math.floorMod((hash[right]-hash[left-1]*powersOfA[right-left+1]),B); //Math.floorMod
    }
}
