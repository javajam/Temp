package com.safeway.scanandgo.services.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("weight_item")
    @Expose
    private Boolean weightItem;
    @SerializedName("item_id")
    @Expose
    private String itemId;
    @SerializedName("sell_price")
    @Expose
    private Double sellPrice;
    @SerializedName("link_code")
    @Expose
    private String linkCode;
    @SerializedName("ext_description")
    @Expose
    private String extDescription;
    @SerializedName("pos_description")
    @Expose
    private String posDescription;
    @SerializedName("crv_item")
    @Expose
    private Boolean crvItem;
    @SerializedName("sell_multiple")
    @Expose
    private Integer sellMultiple;
    @SerializedName("club_item")
    @Expose
    private Boolean clubItem;
    @SerializedName("restricted_item")
    @Expose
    private Boolean restrictedItem;
    @SerializedName("dept")
    @Expose
    private String dept;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("_id")
    @Expose
    private Id id;

    public Boolean getWeightItem() {
        return weightItem;
    }

    public void setWeightItem(Boolean weightItem) {
        this.weightItem = weightItem;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getLinkCode() {
        return linkCode;
    }

    public void setLinkCode(String linkCode) {
        this.linkCode = linkCode;
    }

    public String getExtDescription() {
        return extDescription;
    }

    public void setExtDescription(String extDescription) {
        this.extDescription = extDescription;
    }

    public String getPosDescription() {
        return posDescription;
    }

    public void setPosDescription(String posDescription) {
        this.posDescription = posDescription;
    }

    public Boolean getCrvItem() {
        return crvItem;
    }

    public void setCrvItem(Boolean crvItem) {
        this.crvItem = crvItem;
    }

    public Integer getSellMultiple() {
        return sellMultiple;
    }

    public void setSellMultiple(Integer sellMultiple) {
        this.sellMultiple = sellMultiple;
    }

    public Boolean getClubItem() {
        return clubItem;
    }

    public void setClubItem(Boolean clubItem) {
        this.clubItem = clubItem;
    }

    public Boolean getRestrictedItem() {
        return restrictedItem;
    }

    public void setRestrictedItem(Boolean restrictedItem) {
        this.restrictedItem = restrictedItem;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

}
