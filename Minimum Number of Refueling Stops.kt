fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
    if(stations.size == 0) return if(target<=startFuel) 0 else -1
    val queue: Queue<Int> = PriorityQueue(Collections.reverseOrder())
    var fuelLeft = startFuel
    var distanceCovered = 0
    for(station in stations){
        val distanceBetweenTwoStations = station[0]-distanceCovered
        distanceCovered = station[0]
        fuelLeft -= distanceBetweenTwoStations
        while(!queue.isEmpty() && fuelLeft<0) fuelLeft+=queue.remove()
        if(fuelLeft<0) return -1
        queue.offer(station[1])
    }
    val lastDistance = target - stations.last()[0]
    fuelLeft -= lastDistance
    while(!queue.isEmpty() && fuelLeft<0) fuelLeft+=queue.remove()
    if(fuelLeft<0) return -1
    return stations.size-queue.size
}
