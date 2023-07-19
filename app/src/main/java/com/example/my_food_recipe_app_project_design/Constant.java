package com.example.my_food_recipe_app_project_design;

public class Constant {
    public static String sharedpreferencename = "userdata";
    public final static String email_key = "email";
    public final static String u_id = "u_id";
    //url for API
    public final static String base = "http://192.168.1.68/food/API/";
    //for registration
    public final static String reg_URL = base + "addUser.php";
    // for Login
    public final static String login_URL =  base + "loginApi.php";
    // for category
    public final static String categories_URL = base + "viewCategories.php";
    //for get recipe list
    public static final String getRecipeList = base + "viewRecipe.php";
    // for recipe image
    public static final String recipeImage = "http://192.168.1.68/food/admin/";
    // url for Feedback
    public static final String addFeedback_URL= base + "addFeedback.php";
}
