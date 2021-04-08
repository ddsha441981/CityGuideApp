package com.example.cityguideapp.HelperClasses.HomeAdpater;

public class MostViewedHelperClass {

    int msImage;
    String msTitle,msDesc;

    public MostViewedHelperClass(int msImage, String msTitle, String msDesc) {
        this.msImage = msImage;
        this.msTitle = msTitle;
        this.msDesc = msDesc;
    }

    public int getMsImage() {
        return msImage;
    }

    public void setMsImage(int msImage) {
        this.msImage = msImage;
    }

    public String getMsTitle() {
        return msTitle;
    }

    public void setMsTitle(String msTitle) {
        this.msTitle = msTitle;
    }

    public String getMsDesc() {
        return msDesc;
    }

    public void setMsDesc(String msDesc) {
        this.msDesc = msDesc;
    }
}
