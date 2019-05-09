package com.zf.pojo;

public class Iteminfo {
    private Short itemid;

    private String itemname;

    private Short itemscore;

    private String itemcontent;

    private Double itemPrice;

    private String itemImgPath;

    public String getItemImgPath() {
        return itemImgPath;
    }

    public void setItemImgPath(String itemImgPath) {
        this.itemImgPath = itemImgPath;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Short getItemid() {
        return itemid;
    }

    public void setItemid(Short itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public Short getItemscore() {
        return itemscore;
    }

    public void setItemscore(Short itemscore) {
        this.itemscore = itemscore;
    }

    public String getItemcontent() {
        return itemcontent;
    }

    public void setItemcontent(String itemcontent) {
        this.itemcontent = itemcontent == null ? null : itemcontent.trim();
    }
}