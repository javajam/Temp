package com.safeway.scanandgo.models;

import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("item_id")
    private String itemId;

    @SerializedName("sku")
    private String sku;

    @SerializedName("pos_description")
    private String posDescription;

    @SerializedName("ext_description")
    private String extDescription;

    @SerializedName("sell_price")
    private Double sellPrice;

    @SerializedName("sell_multiple")
    private Integer sellMultiple;

    @SerializedName("link_code")
    private String linkCode;

    @SerializedName("dept")
    private String dept;

    private final static long serialVersionUID = 6938836693246998027L;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getPosDescription() {
        return posDescription;
    }

    public void setPosDescription(String posDescription) {
        this.posDescription = posDescription;
    }

    public String getExtDescription() {
        return extDescription;
    }

    public void setExtDescription(String extDescription) {
        this.extDescription = extDescription;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getSellMultiple() {
        return sellMultiple;
    }

    public void setSellMultiple(Integer sellMultiple) {
        this.sellMultiple = sellMultiple;
    }

    public String getLinkCode() {
        return linkCode;
    }

    public void setLinkCode(String linkCode) {
        this.linkCode = linkCode;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

}
