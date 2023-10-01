package com.kennedy.servicedelivery.core.models;

import com.kennedy.servicedelivery.core.dto.PartnerFormRequest;

import java.util.UUID;

public class Partner {

    private String id;
    private String tradingName;
    private String ownerName;
    private String document;

    private CoverageArea coverageArea;
    private Address address;

    public Partner() {
    }

    public Partner(PartnerFormRequest form) {
        this.id = UUID.randomUUID().toString();
        this.tradingName = form.tradingName();
        this.ownerName = form.ownerName();
        this.document = form.document();
        this.coverageArea = form.coverageArea();
        this.address = form.address();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTradingName() {
        return tradingName;
    }

    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public CoverageArea getCoverageArea() {
        return coverageArea;
    }

    public void setCoverageArea(CoverageArea coverageArea) {
        this.coverageArea = coverageArea;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
