package com.kennedy.servicedelivery.core.usecases;

import com.kennedy.servicedelivery.core.dto.PartnerFormRequest;

public interface CreatePartnerUseCase {

    void createPartner(PartnerFormRequest partner);
}
