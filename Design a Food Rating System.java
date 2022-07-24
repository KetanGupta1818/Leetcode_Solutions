class FoodRatings {
    Map<String,Integer> cuisinesWithIndex;
    List<Cuisines> cuisinesObjectList;
    Map<String,String> foodWithCuisine;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int numberOfCuisines = 0;
        cuisinesWithIndex = new HashMap<>();
        cuisinesObjectList = new ArrayList<>();
        foodWithCuisine = new HashMap<>();
        for(int i=0;i<foods.length;i++){
            String cuisine = cuisines[i];
            String food = foods[i];
            Integer rating = ratings[i];
            foodWithCuisine.put(food,cuisine);
            if(!cuisinesWithIndex.containsKey(cuisine)){
                cuisinesWithIndex.put(cuisine,numberOfCuisines);
                cuisinesObjectList.add(new Cuisines());
                numberOfCuisines++;
            }
            cuisinesObjectList.get(cuisinesWithIndex.get(cuisine)).addFood(food,rating);
        }
        
    }

    public void changeRating(String food, int newRating) {
        cuisinesObjectList.get(cuisinesWithIndex.get(foodWithCuisine.get(food))).updateRatings(food,newRating);
    }

    public String highestRated(String cuisine) {
        return cuisinesObjectList.get(cuisinesWithIndex.get(cuisine)).highestRatedFood();
    }
}
class Cuisines{
    private TreeSet<RatingStorage> setOfRatings;
    private Map<String,Integer> currentRatings;

    public Cuisines(){
        setOfRatings = new TreeSet<>((rs1,rs2)->{
            if(rs1.rating==rs2.rating) return rs1.nameOfFood.compareTo(rs2.nameOfFood);
            return rs2.rating-rs1.rating;
        });
        currentRatings = new HashMap<>();
    }
    public void addFood(String food, Integer rating){
        setOfRatings.add(new RatingStorage(rating,food));
        currentRatings.put(food,rating);
    }
    public void updateRatings(String food, Integer rating){
        setOfRatings.remove(new RatingStorage(currentRatings.get(food),food));
        setOfRatings.add(new RatingStorage(rating,food));
        currentRatings.put(food,rating);
    }
    public String highestRatedFood(){
        return setOfRatings.first().nameOfFood;
    }
}
class RatingStorage{
    int rating;
    String nameOfFood;

    public RatingStorage(int rating, String nameOfFood){
        this.rating = rating;
        this.nameOfFood = nameOfFood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RatingStorage that)) return false;
        return rating == that.rating && Objects.equals(nameOfFood, that.nameOfFood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rating, nameOfFood);
    }
}
