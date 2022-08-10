class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        TreeSet<Range> rangeTreeSet = new TreeSet<>(Comparator.comparingInt(r -> r.left));
        rangeTreeSet.add(new Range(1,n));
        if(m == n) return n;
        if(m > n) return -1;
        for(int i=n-1;i>=0;i--){
            int point = arr[i];
            Range bigRange = rangeTreeSet.floor(new Range(point,0));
            rangeTreeSet.remove(bigRange);
            if(bigRange == null){
                System.out.println("Error: no range exits");
                return -101;
            }
            Range[] splitRanges = Range.split(bigRange,point);
            for(Range range: splitRanges){
                if(range.size() == m) return i;
                rangeTreeSet.add(range);
            }
        }
        return -1;
    }
}
class Range{
    int left;
    int right;

    public Range(int left, int right) {
        this.left = left;
        this.right = right;
    }
    
    public static Range[] split(Range range, int point){
        int leftSize = point - range.left;
        int rightSize = range.right - point;
        if(leftSize!=0 && rightSize!=0) return new Range[]{
                new Range(range.left,point-1),new Range(point+1,range.right)
        };
        else if(leftSize!=0) return new Range[]{new Range(range.left,point-1)};
        else if(rightSize!=0) return new Range[]{new Range(point+1,range.right)};
        else return new Range[]{};
    }
    
    public int size(){
        return this.right-this.left+1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Range range)) return false;
        return left == range.left && right == range.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
