package com.kennedy.servicedelivery.core.entities;

import java.util.ArrayList;
import java.util.List;

public class Address {

    private String type;
    private final List<Double> coordinates = new ArrayList<>();

    public Address() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }
}
