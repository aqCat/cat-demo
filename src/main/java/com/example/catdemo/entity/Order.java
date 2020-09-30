package com.example.catdemo.entity;

import lombok.Data;

@Data
public class Order {
    private long id;
    private long groupID;
    private long shopID;
    private long userID;
    private long goodsID;
    private int action;
    private long actionTime;
    private long createTime;
}
