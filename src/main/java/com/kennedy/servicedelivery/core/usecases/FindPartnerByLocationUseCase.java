package com.kennedy.servicedelivery.core.usecases;

import com.kennedy.servicedelivery.core.entities.Partner;

public interface FindPartnerByLocationUseCase {

    Partner findByLocation(double longitude, double latitude);
}
