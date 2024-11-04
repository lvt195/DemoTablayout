package com.example.myapplication.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private int id;
    private String name;
    private String description;
    private int image;

    public Category(int id, String name, String description, int image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public static List<Category> createCategory() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Category 1", "Description 1", 0));
        categories.add(new Category(2, "Category 2", "Description 2", 0));
        categories.add(new Category(3, "Category 3", "Description 3", 0));
        categories.add(new Category(4, "Category 4", "Description 4", 0));
        return  categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
