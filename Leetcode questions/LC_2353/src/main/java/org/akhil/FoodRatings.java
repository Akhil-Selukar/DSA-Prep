package org.akhil;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class FoodRatings {

    private class Pair{
        String food;
        int rating;

        public Pair(String food, int rating){
            this.food = food;
            this.rating = rating;
        }
    }

    // we need to update rating based on food name hence we need some mapping to identify old rating from food name
    Map<String, Integer> foodToRating = new HashMap<>();
    // we need to return highest rated food from given cuisine so we need some data structure which can store food based on cuisine and also in sorted order
    Map<String, TreeSet<Pair>> cuisineToFoodPair = new HashMap<>();
    // the map cuisinesToFoodPair has details of food based on cuisine, so whenever we are changing rating of any food it will be updated in foodToRating easily
    // but same need to be updated in cuisineToFoodPair as well then only PriorityQueue can work. So from that food we will need to identify the cuisine as well.
    Map<String, String> foodToCuisine = new HashMap<>();    // from food we will get cuisine and using cuisine and food we will update the rating in pair

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for(int i=0; i<n; i++){
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            // populate all 3 maps
            foodToRating.put(food, rating);
            foodToCuisine.put(food, cuisine);
            Pair pair = new Pair(food, -rating);
            if(!cuisineToFoodPair.containsKey(cuisine)){
                cuisineToFoodPair.put(cuisine, new TreeSet<Pair>((a, b)->{
                    if(a.rating == b.rating){
                        return a.food.compareTo(b.food);
                    }
                    return a.rating - b.rating;
                }));
            }
            cuisineToFoodPair.get(cuisine).add(pair);
        }
    }

    public void changeRating(String food, int newRating) {
        int oldRating = foodToRating.get(food);
        foodToRating.put(food, newRating);
        String cuisine = foodToCuisine.get(food);
        TreeSet<Pair> cuisineSet = cuisineToFoodPair.get(cuisine);
        Pair oldEntry = new Pair(food, -oldRating);
        cuisineSet.remove(oldEntry);            // priority queue is not used because of this.
        Pair newEntry = new Pair(food, -newRating);
        cuisineSet.add(newEntry);
        cuisineToFoodPair.put(cuisine, cuisineSet);
    }

    public String highestRated(String cuisine) {
        return cuisineToFoodPair.get(cuisine).first().food;
    }
}
