package com.wordgame.model;
// 商店道具类
public class Item {
    private String name;        // 道具名称
    private int price;          // 价格
    private String effect;// 效果描述（如"恢复1点生命值"）

    public Item() {
    }

    public Item(String name, int price, String effect) {
        this.name = name;
        this.price = price;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}
