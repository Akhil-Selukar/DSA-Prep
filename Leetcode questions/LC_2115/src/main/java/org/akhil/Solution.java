package org.akhil;

import java.util.*;

public class Solution {

    // Solution 1 - Using Graph
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        Map<String, List<String>> graph = new HashMap<>(); // ingredient -> list of recipes
        Map<String, Integer> indegree = new HashMap<>();   // recipe -> count of needed ingredients
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();

        // Step 1: Build graph and indegree map
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            indegree.put(recipe, ingredients.get(i).size());

            for (String ing : ingredients.get(i)) {
                graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipe);
            }
        }

        // Step 2: Perform BFS
        Queue<String> queue = new LinkedList<>(available);

        while (!queue.isEmpty()) {
            String item = queue.poll();
            if (!graph.containsKey(item)) continue;

            for (String recipe : graph.get(item)) {
                indegree.put(recipe, indegree.get(recipe) - 1);
                if (indegree.get(recipe) == 0) {
                    result.add(recipe);
                    queue.add(recipe);
                }
            }
        }

        return result;
    }

    // Solution 2 - Faster solution
    String rootRecipe = "";
//    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
//        Set<String> supplySet = new HashSet<>(Arrays.asList(supplies));
//
//        Map<String, Integer> recipeIdx = new HashMap<>();
//        for(int i=0;i<recipes.length;i++){
//            recipeIdx.put(recipes[i],i);
//        }
//
//        List<String> result = new ArrayList<>();
//        Map<String, Boolean> visited = new HashMap<>();
//        Set<String> visitedRecipes = new HashSet<>();
//        for(int i=0;i<recipes.length;i++){
//            rootRecipe = recipes[i];
//            if(dfs(recipes[i], ingredients, supplySet, recipeIdx, visited, visitedRecipes)){
//                result.add(recipes[i]);
//            }
//        }
//        return result;
//    }
//
//    private boolean dfs(String recipe, List<List<String>> ingredients,
//                        Set<String> supplySet,  Map<String, Integer> recipeIdx,
//                        Map<String, Boolean> visited, Set<String> visitedRecipes){
//        if(visited.containsKey(recipe)) return visited.get(recipe);
//        if(visitedRecipes.contains(recipe)) return false;
//        visitedRecipes.add(recipe);
//        List<String> recipeIngredients = ingredients.get(recipeIdx.get(recipe));
//        // boolean canCreate = true;
//        for(String ingredient : recipeIngredients){
//            if(recipeIdx.containsKey(ingredient)){
//                if(!dfs(ingredient, ingredients, supplySet, recipeIdx, visited, visitedRecipes)){
//                    visited.put(ingredient,false);
//                    return false;
//                }
//            }
//            else if(!supplySet.contains(ingredient)){
//                return false;
//            }
//        }
//        visited.put(recipe,true);
//        return true;
//    }
}
