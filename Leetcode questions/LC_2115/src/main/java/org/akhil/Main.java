package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] recipes = {"bread","sandwich","burger"};
        List<List<String>> ingredients = new ArrayList<>();
        List<String> l1 = List.of(new String[]{"yeast", "flour"});
        List<String> l2 = List.of(new String[]{"bread","meat"});
        List<String> l3 = List.of(new String[]{"sandwich","meat","bread"});
        ingredients.add(l1);
        ingredients.add(l2);
        ingredients.add(l3);

        String[] supplies = {"yeast","flour","meat"};

        Solution solution = new Solution();
        System.out.println(solution.findAllRecipes(recipes, ingredients, supplies));
    }
}