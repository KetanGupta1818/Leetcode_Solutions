var nearestValidPoint = function(x, y, points) {
    let index=-1,min=Number.MAX_VALUE;
    for(let [i,point] of points.entries()){
        if(point[0]===x || point[1]===y){
            let val = Math.abs(point[0]-x)+Math.abs(point[1]-y);
            if(val<min) {
                index=i;
                min = val;
            }
        }
    }
    return index;
};
