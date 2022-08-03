class MyCalendar {
    TreeSet<Range> set;
    public MyCalendar() {
        this.set = new TreeSet<>(Comparator.comparingInt(r -> r.start));
    }

    public boolean book(int start, int end) {
        Range prevBooking = set.floor(new Range(end-1,Integer.MAX_VALUE));
        if(prevBooking==null || prevBooking.end<start){
            set.add(new Range(start,end-1));
            return true;
        }
        return false;
    }
}
class Range{
    int start;
    int end;
    public Range(int start, int end){
        this.start = start;
        this.end = end;
    }
}
