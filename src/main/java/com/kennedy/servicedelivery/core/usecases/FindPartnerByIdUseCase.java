package com.kennedy.servicedelivery.core.usecases;

import com.kennedy.servicedelivery.core.models.Partner;

public interface FindPartnerByIdUseCase {

    Partner findById(String id);
}
