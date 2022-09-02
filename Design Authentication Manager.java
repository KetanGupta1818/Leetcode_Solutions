class AuthenticationManager {
    Map<String,Integer> map = new HashMap<>();
    int timeToLive;
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId,currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if(map.containsKey(tokenId) && map.get(tokenId)+timeToLive>currentTime)
        map.put(tokenId,currentTime);
    }

    public int countUnexpiredTokens(int currentTime) {
        int counter = 0;
        for(String id: map.keySet()){
            if(map.get(id)+timeToLive>currentTime) counter++;
        }
        return counter;
    }
}
