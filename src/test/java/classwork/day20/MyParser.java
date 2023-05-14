package classwork.day20;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyParser {
    public static void main(String[] args) throws IOException {
//        new MyParser().parseGSON();
        new MyParser().fromGSON();
    }


    private String JSON = "src/test/resources/classwork21/recipe.json";

    public void parseGSON() throws IOException {
        Gson gson = new Gson();
        Recipe recipe = gson.fromJson(new JsonReader(new FileReader(JSON)), Recipe.class);
        System.out.println(recipe.getIngredlist());
        System.out.println(recipe.getPreptime());
        System.out.println(recipe.getRecipename());
    }

    public void fromGSON() {
//        Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(new Ingredient("Pasta",450));
        ingredientList.add(new Ingredient("Water",2000));
        ingredientList.add(new Ingredient("Salt",30));
        Recipe recipe = new Recipe("Pasta", ingredientList,20);
        System.out.println(gson.toJson(recipe));
    }

    public String fromGSON(Search search) {
        Gson gson = new Gson();
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(search);
    }
}
