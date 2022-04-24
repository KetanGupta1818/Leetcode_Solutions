class UndergroundSystem {
    Map<Integer,Person> mapOfIdWithPerson;
    Map<String,Route> mapOfRouteNameWithRoute;
    public UndergroundSystem() {
        mapOfIdWithPerson = new HashMap<>();
        mapOfRouteNameWithRoute = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        Person person = new Person(t,stationName);
        mapOfIdWithPerson.put(id,person);
    }

    public void checkOut(int id, String stationName, int t) {
        Person person = mapOfIdWithPerson.get(id);
        String source = person.checkInLocation;
        String routeName = source+","+ stationName;
        Route route;
        if(!mapOfRouteNameWithRoute.containsKey(routeName)) {
            route = new Route(source, stationName);
        }
        else route = mapOfRouteNameWithRoute.get(routeName);
        route.addTrip(person.checkInTime,t);
        mapOfRouteNameWithRoute.put(routeName,route);
        mapOfIdWithPerson.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        return mapOfRouteNameWithRoute.get(startStation+","+endStation).getAverage();
    }
}
class Person{
    int checkInTime;
    String checkInLocation;

    public Person(int checkInTime, String checkInLocation){
        this.checkInTime = checkInTime;
        this.checkInLocation = checkInLocation;
    }
}
class Route{
    String source;
    String destination;
    int numberOfTrips;
    int timeSpend;

    public Route(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }
    public void addTrip(int checkInTime, int checkOutTime){
        timeSpend += checkOutTime - checkInTime;
        numberOfTrips++;
    }
    public double getAverage(){
        return ((double) timeSpend)/numberOfTrips;
    }
}
