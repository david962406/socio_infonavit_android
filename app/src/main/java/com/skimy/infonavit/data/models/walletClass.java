
package com.skimy.infonavit.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class walletClass {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("display_index")
    @Expose
    private Integer displayIndex;
    @SerializedName("display_text")
    @Expose
    private String displayText;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("max_level")
    @Expose
    private Integer maxLevel;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("benevit_count")
    @Expose
    private Integer benevitCount;
    @SerializedName("mobile_cover_url")
    @Expose
    private Object mobileCoverUrl;
    @SerializedName("desktop_cover_url")
    @Expose
    private Object desktopCoverUrl;
    @SerializedName("member_level")
    @Expose
    private Integer memberLevel;
    @SerializedName("primary_color")
    @Expose
    private String primaryColor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(Integer displayIndex) {
        this.displayIndex = displayIndex;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(Integer maxLevel) {
        this.maxLevel = maxLevel;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBenevitCount() {
        return benevitCount;
    }

    public void setBenevitCount(Integer benevitCount) {
        this.benevitCount = benevitCount;
    }

    public Object getMobileCoverUrl() {
        return mobileCoverUrl;
    }

    public void setMobileCoverUrl(Object mobileCoverUrl) {
        this.mobileCoverUrl = mobileCoverUrl;
    }

    public Object getDesktopCoverUrl() {
        return desktopCoverUrl;
    }

    public void setDesktopCoverUrl(Object desktopCoverUrl) {
        this.desktopCoverUrl = desktopCoverUrl;
    }

    public Integer getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(Integer memberLevel) {
        this.memberLevel = memberLevel;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

}
