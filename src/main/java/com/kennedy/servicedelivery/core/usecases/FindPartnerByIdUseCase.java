package com.kennedy.servicedelivery.core.usecases;

import com.kennedy.servicedelivery.core.entities.Partner;

public interface FindPartnerByIdUseCase {

    Partner findById(String id);
}
