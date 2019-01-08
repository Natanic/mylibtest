package com.photolib;

import java.io.Serializable;

/**
 * Created by qianjian on 2017/6/29.
 */

public class CropParam implements Serializable{

    //裁剪比例
    private int aspectX = 1;
    private int aspectY = 1;
    private int outputY = 400;
    //输出大小
    private int outputX = 400;
    public int getAspectX() {
        return aspectX;
    }

    public void setAspectX(int aspectX) {
        this.aspectX = aspectX;
    }



    public int getOutputX() {
        return outputX;
    }

    public void setOutputX(int outputX) {
        this.outputX = outputX;
    }

    public int getOutputY() {
        return outputY;
    }

    public void setOutputY(int outputY) {
        this.outputY = outputY;
    }

    public int getAspectY() {
        return aspectY;
    }

    public void setAspectY(int aspectY) {
        this.aspectY = aspectY;
    }




    public CropParam(int aspectX,int aspectY,int outputX,int outputY){
        this.aspectX=aspectX;
        this.aspectY=aspectY;
        this.outputX=outputX;
        this.outputY=outputY;

    }



}
