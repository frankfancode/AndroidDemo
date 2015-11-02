package com.frankfancode.androiddemo.entity;

/**
 * Created by Frank on 2015/11/1.
 * 展示的卡片
 * 有图片和文字描述
 */
public class Card {
    public Card(String imageUri, String description) {
        this.imageUri = imageUri;
        this.description = description;
    }

    public String imageUri;
    public String description;

}
