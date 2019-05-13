package com.zf.pojo;

import java.util.Date;

public class Recordinfo {
    private Short recordid;

    private String username;

    private Short recordscore;

    private Date starttime;

    private Short interval;

    private Short itemid;

    private String recordcontent;

    private String userPhone;

    private String address;

    private Double totalPrice;

    private String itemIdNum;

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getItemIdNum() {
        return itemIdNum;
    }

    public void setItemIdNum(String itemIdNum) {
        this.itemIdNum = itemIdNum;
    }

    public Short getRecordid() {
        return recordid;
    }

    public void setRecordid(Short recordid) {
        this.recordid = recordid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Short getRecordscore() {
        return recordscore;
    }

    public void setRecordscore(Short recordscore) {
        this.recordscore = recordscore;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Short getInterval() {
        return interval;
    }

    public void setInterval(Short interval) {
        this.interval = interval;
    }

    public Short getItemid() {
        return itemid;
    }

    public void setItemid(Short itemid) {
        this.itemid = itemid;
    }

    public String getRecordcontent() {
        return recordcontent;
    }

    public void setRecordcontent(String recordcontent) {
        this.recordcontent = recordcontent == null ? null : recordcontent.trim();
    }
}