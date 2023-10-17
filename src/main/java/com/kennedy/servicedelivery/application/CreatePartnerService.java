package com.kennedy.servicedelivery.application;

import com.kennedy.servicedelivery.core.dto.PartnerFormRequest;
import com.kennedy.servicedelivery.core.models.Partner;
import com.kennedy.servicedelivery.core.usecases.CreatePartnerUseCase;
import com.kennedy.servicedelivery.core.utils.Util;
import com.kennedy.servicedelivery.db.entities.PartnerEntity;
import com.kennedy.servicedelivery.db.repositories.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CreatePartnerService implements CreatePartnerUseCase {

    private PartnerRepository repository;

    @Autowired
    public CreatePartnerService(PartnerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createPartner(PartnerFormRequest form) {
        Partner partner = new Partner(form);
        String coordinatesCoverageArea = Util.convertDataCoordinatesCoverageAreaAsString(form.coverageArea().getCoordinates());
        String coordinatesAddress = Util.convertDataCoordinatesAddressAsString(form.address().getCoordinates());

        repository.save(new PartnerEntity(
                partner.getId(),
                partner.getTradingName(),
                partner.getOwnerName(),
                partner.getDocument(),
                partner.getCoverageArea().getType(),
                coordinatesCoverageArea,
                partner.getAddress().getType(),
                coordinatesAddress
        ));
    }

}
