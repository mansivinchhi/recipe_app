//package com.example.cookmate;
package com.example.my_food_recipe_app_project_design;

public class CategoryModel
{
    // three variable for CategoryId,CategoryName,CategoryImage
    int CategoryID;
    String CategoryName;
    String CategoryImage;

    //Constructor for All three
    public CategoryModel(int categoryID, String categoryName, String categoryImage) {
        this.CategoryID = categoryID;
        this.CategoryName = categoryName;
        this.CategoryImage = categoryImage;
    }

    // now three required getter & setter Method
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

    public void setCategoryImage(String categoryImage) {
        this.CategoryImage = categoryImage;
    }
    public String getCategoryImage() {
        return CategoryImage;
    }
}
