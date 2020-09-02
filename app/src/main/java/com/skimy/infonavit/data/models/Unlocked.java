
package com.skimy.infonavit.data.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Unlocked {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("instructions")
    @Expose
    private String instructions;
    @SerializedName("expiration_date")
    @Expose
    private String expirationDate;
    @SerializedName("active")
    @Expose
    private boolean active;
    @SerializedName("primary_color")
    @Expose
    private String primaryColor;
    @SerializedName("has_coupons")
    @Expose
    private boolean hasCoupons;
    @SerializedName("vector_file_name")
    @Expose
    private String vectorFileName;
    @SerializedName("vector_full_path")
    @Expose
    private String vectorFullPath;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("wallet")
    @Expose
    private walletClass wallet;
    @SerializedName("territories")
    @Expose
    private List<Territory> territories = null;
    @SerializedName("ally")
    @Expose
    private Ally ally;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public boolean isHasCoupons() {
        return hasCoupons;
    }

    public void setHasCoupons(boolean hasCoupons) {
        this.hasCoupons = hasCoupons;
    }

    public String getVectorFileName() {
        return vectorFileName;
    }

    public void setVectorFileName(String vectorFileName) {
        this.vectorFileName = vectorFileName;
    }

    public String getVectorFullPath() {
        return vectorFullPath;
    }

    public void setVectorFullPath(String vectorFullPath) {
        this.vectorFullPath = vectorFullPath;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public walletClass getWallet() {
        return wallet;
    }

    public void setWallet(walletClass wallet) {
        this.wallet = wallet;
    }

    public List<Territory> getTerritories() {
        return territories;
    }

    public void setTerritories(List<Territory> territories) {
        this.territories = territories;
    }

    public Ally getAlly() {
        return ally;
    }

    public void setAlly(Ally ally) {
        this.ally = ally;
    }

}
