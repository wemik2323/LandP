package org.PrescentV;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
public class Devicelist {
    @SerializedName("arrAppliances")
    public ArrayList<Appliances> arrAppliances;

    public Devicelist() {
        this.arrAppliances = new ArrayList<Appliances>();
    }

    public Devicelist(ArrayList<Appliances> arrAppliances) {
        this.arrAppliances = arrAppliances;
    }
}
