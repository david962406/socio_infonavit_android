
package com.skimy.infonavit.data.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LandingResponse {

    @SerializedName("unlocked")
    @Expose
    private List<BenevitClass> unlocked = null;
    @SerializedName("locked")
    @Expose
    private List<BenevitClass> locked = null;

    public List<BenevitClass> getUnlocked() {
        return unlocked;
    }

    public void setUnlocked(List<BenevitClass> unlocked) {
        this.unlocked = unlocked;
    }

    public List<BenevitClass> getLocked() {
        return locked;
    }

    public void setLocked(List<BenevitClass> locked) {
        this.locked = locked;
    }

}
