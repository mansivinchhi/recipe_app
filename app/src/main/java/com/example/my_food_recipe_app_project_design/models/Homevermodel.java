package com.example.my_food_recipe_app_project_design.models;

public class Homevermodel {
    int image;
    String Name;

    public Homevermodel(int image, String Name) {
        this.image = image;
        this.Name = Name;
    }

    public static void add(Homevermodel pizza) {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}
