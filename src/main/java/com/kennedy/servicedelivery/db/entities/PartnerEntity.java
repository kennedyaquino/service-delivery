package com.kennedy.servicedelivery.db.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_partner")
public class PartnerEntity {

    @Id
    private String id;
    private String tradingName;
    private String ownerName;
    private String document;
    private String typeCoverageArea;
    private String coordinatesCoverageArea;
    private String typeAddress;
    private String coordinatesAddress;

    public PartnerEntity(String id, String tradingName, String ownerName, String document, String typeCoverageArea, String coordinatesCoverageArea, String typeAddress, String coordinatesAddress) {
        this.id = id;
        this.tradingName = tradingName;
        this.ownerName = ownerName;
        this.document = document;
        this.typeCoverageArea = typeCoverageArea;
        this.coordinatesCoverageArea = coordinatesCoverageArea;
        this.typeAddress = typeAddress;
        this.coordinatesAddress = coordinatesAddress;
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

    public String getTypeCoverageArea() {
        return typeCoverageArea;
    }

    public void setTypeCoverageArea(String typeCoverageArea) {
        this.typeCoverageArea = typeCoverageArea;
    }

    public String getCoordinatesCoverageArea() {
        return coordinatesCoverageArea;
    }

    public void setCoordinatesCoverageArea(String coordinatesCoverageArea) {
        this.coordinatesCoverageArea = coordinatesCoverageArea;
    }

    public String getTypeAddress() {
        return typeAddress;
    }

    public void setTypeAddress(String typeAddress) {
        this.typeAddress = typeAddress;
    }

    public String getCoordinatesAddress() {
        return coordinatesAddress;
    }

    public void setCoordinatesAddress(String coordinatesAddress) {
        this.coordinatesAddress = coordinatesAddress;
    }
}
