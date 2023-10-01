package com.kennedy.servicedelivery.core.usecases;

import com.kennedy.servicedelivery.core.models.Partner;

public interface FindPartnerByLocationUseCase {

    Partner findByLocation(double longitude, double latitude);
}
