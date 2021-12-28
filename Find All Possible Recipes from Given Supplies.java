class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> answer = new ArrayList<>();
        HashMap<String,Integer> recipesInDegrees = new HashMap<>();
        HashMap<String, List<String>> ingredientsWithRecipes = new HashMap<>();
        for(int i=0;i<ingredients.size();i++){
            List<String> ingredientList = ingredients.get(i);
            recipesInDegrees.put(recipes[i],ingredientList.size());
            for(String ingredient: ingredientList){
                if(ingredientsWithRecipes.containsKey(ingredient)){
                    List<String> recipeList = ingredientsWithRecipes.get(ingredient);
                    recipeList.add(recipes[i]);
                    ingredientsWithRecipes.put(ingredient,recipeList);
                }
                else{
                    List<String> newRecipe = new ArrayList<>();
                    newRecipe.add(recipes[i]);
                    ingredientsWithRecipes.put(ingredient,newRecipe);
                }
            }
                
        }
        Queue<String> queuePreparedIngredients = new  ArrayDeque<>();
        for(String supply: supplies){
            if(ingredientsWithRecipes.containsKey(supply)) queuePreparedIngredients.offer(supply);
        }
        while(!queuePreparedIngredients.isEmpty()){
            String currentIngredient = queuePreparedIngredients.poll();
            List<String> recipeList = ingredientsWithRecipes.get(currentIngredient);
            if(recipeList==null) continue;
            for(String recipe: recipeList){
                int inDegree = recipesInDegrees.get(recipe) -1;
                if(inDegree==0){
                    queuePreparedIngredients.offer(recipe);
                    answer.add(recipe);
                }
                recipesInDegrees.put(recipe,inDegree);
            }
        }
        return answer;
    }

}
