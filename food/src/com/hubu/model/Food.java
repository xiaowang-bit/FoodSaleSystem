package com.hubu.model;

/**
 * @author star
 * @date 2020/1/10 10:18
 * @description 食物表
 */
public class Food {
    private int id;
    private String name;
    private float price;
    private String imagepath;
    private String description;
    private int category_id;

    public Food(int id, String name, float price, String imagepath, String description, int category_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imagepath = imagepath;
        this.description = description;
        this.category_id = category_id;
    }

    public Food() {
        super();
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", imagepath='" + imagepath + '\'' +
                ", description='" + description + '\'' +
                ", category_id=" + category_id +
                '}';
    }
}
