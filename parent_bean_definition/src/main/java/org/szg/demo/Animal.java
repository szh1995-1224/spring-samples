package org.szg.demo;

public class Animal {
    private String category;

    @Override
    public String toString() {
        return "Animal{" +
                "category='" + category + '\'' +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
