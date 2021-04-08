package com.example.cityguideapp.HelperClasses.HomeAdpater;

public class CategoryHelperCalss {

    int imageCategory;
    String titleCategory;

    public CategoryHelperCalss(int imageCategory, String titleCategory) {
        this.imageCategory = imageCategory;
        this.titleCategory = titleCategory;
    }

    public int getImageCategory() {
        return imageCategory;
    }

    public void setImageCategory(int imageCategory) {
        this.imageCategory = imageCategory;
    }

    public String getTitleCategory() {
        return titleCategory;
    }

    public void setTitleCategory(String titleCategory) {
        this.titleCategory = titleCategory;
    }
}
