//rc is number of right moving cars at current position
//sc is number of stationary cars at current position
//we do not need a lc because we will be moving left to right and previously moving left direction cars won't lead to collisions..

class Solution {
    public int countCollisions(String directions) {
        int collisions=0;
        int rc=0,sc=0;
        for(int i=0;i<directions.length();i++){
            char car = directions.charAt(i);
            if(car=='S'){
                collisions+=rc; //All right moving cars will collide
                rc=0;
                sc=1;
            }
            else if(car=='L'){
                if(sc==1) collisions++;
                else if(rc!=0){
                    collisions+=2;
                    rc--;
                    collisions+=rc;
                    rc=0;
                    sc=1;
                }
            }
            else{
                sc=0;
                rc++;
            }
        }
        return collisions;
    }
}
