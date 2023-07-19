
package com.example.my_food_recipe_app_project_design.models;

public class DailyRecipeModel {

    int CategoryID;
    String CategoryName;
    String CategoryImage;

    public DailyRecipeModel(int categoryID, String categoryName, String categoryImage) {
        this.CategoryID = categoryID;
        this.CategoryName = categoryName;
        this.CategoryImage = categoryImage;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getCategoryImage() {
        return CategoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        CategoryImage = categoryImage;
    }
}