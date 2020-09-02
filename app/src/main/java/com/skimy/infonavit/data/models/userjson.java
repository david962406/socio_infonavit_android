package com.skimy.infonavit.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class userjson {
    @SerializedName("user")
    @Expose
    private com.skimy.infonavit.data.models.user user;

    public userjson(com.skimy.infonavit.data.models.user user) {
        this.user=user;
    }
}
