class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length/2;
        Queue<int[]> cityA = new PriorityQueue<>(Comparator.comparingInt(p -> p[2]));
        Queue<int[]> cityB = new PriorityQueue<>(Comparator.comparingInt(p -> p[2]));
        for(int[] cost: costs){
            int[] trip = {cost[0],cost[1],Math.abs(cost[0]-cost[1])};
            if(cost[0]>cost[1]){ //A trip costs more... We should include this person in B
                if(cityB.size()==n){
                    int[] otherTrip = cityB.poll();
                    assert otherTrip != null;
                    if(otherTrip[2]<trip[2]) {
                        cityA.offer(otherTrip);
                        cityB.offer(trip);
                    }
                    else {
                        cityA.offer(trip);
                        cityB.offer(otherTrip);
                    }
                }
                else{
                    cityB.offer(trip);
                }
            }
            else{
                if(cityA.size()==n){
                    int[] otherTrip = cityA.poll();
                    assert otherTrip != null;
                    if(otherTrip[2]<trip[2]) {
                        cityB.offer(otherTrip);
                        cityA.offer(trip);
                    }
                    else {
                        cityB.offer(trip);
                        cityA.offer(otherTrip);
                    }
                }
                else cityA.offer(trip);
            }
        }
        if(cityA.size()!=n || cityB.size()!=n) System.out.println("Error");
        int sum = 0;
        for(int[] trip: cityA) sum+=trip[0];
        for(int[] trip: cityB) sum+=trip[1];
        return sum;
    }
}
