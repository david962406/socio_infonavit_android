
package com.skimy.infonavit.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ally {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("mini_logo_file_name")
    @Expose
    private String miniLogoFileName;
    @SerializedName("mini_logo_full_path")
    @Expose
    private String miniLogoFullPath;

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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getMiniLogoFileName() {
        return miniLogoFileName;
    }

    public void setMiniLogoFileName(String miniLogoFileName) {
        this.miniLogoFileName = miniLogoFileName;
    }

    public String getMiniLogoFullPath() {
        return miniLogoFullPath;
    }

    public void setMiniLogoFullPath(String miniLogoFullPath) {
        this.miniLogoFullPath = miniLogoFullPath;
    }

}
