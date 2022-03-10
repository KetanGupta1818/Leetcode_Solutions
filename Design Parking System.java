class ParkingSystem {
    int b,m,s;
    public ParkingSystem(int big, int medium, int small) {
        b=big;m=medium;s=small;
    }
    
    public boolean addCar(int carType) {
        switch(carType){
            case 1:
                if(--b>=0) return true;
                break;
            case 2:
                if(--m>=0) return true;
                break;
            default:
                if(--s>=0) return true;
        }
        return false;
    }
}
