```
class SeatManager {
    private Queue<Integer> queue;
    public SeatManager(int n) {
        queue = new PriorityQueue<>();
        for(int i=1;i<=n;i++) queue.offer(i);
    }
    
    public int reserve() {
        return queue.remove();
    }
    public void unreserve(int seatNumber) {
        queue.offer(seatNumber);
    }
}

```
