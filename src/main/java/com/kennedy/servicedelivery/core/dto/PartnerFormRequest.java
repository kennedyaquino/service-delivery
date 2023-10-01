package com.kennedy.servicedelivery.core.dto;

import com.kennedy.servicedelivery.core.models.Address;
import com.kennedy.servicedelivery.core.models.CoverageArea;

public record PartnerFormRequest(String tradingName, String ownerName, String document, CoverageArea coverageArea, Address address) {
}
