package com.example.my_food_recipe_app_project_design.models;

public class HomeHorModel {
    //stape =>1 ( 2 variables)
    int image;
    String name;

    // stape => 2 (now we create a peramerized constructor)

    public HomeHorModel(int image, String name) {
        this.image = image;
        this.name = name;
    }
    // stape => 3 (then we create setter & gatter method of both this)

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
