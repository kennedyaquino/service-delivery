package com.kennedy.servicedelivery.core.models;

import java.util.ArrayList;
import java.util.List;

public class CoverageArea {
    private String type;
    private final List<List<List<List<Double>>>> coordinates = new ArrayList<>();

    public CoverageArea() {
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<List<List<List<Double>>>> getCoordinates() {
        return coordinates;
    }
}
