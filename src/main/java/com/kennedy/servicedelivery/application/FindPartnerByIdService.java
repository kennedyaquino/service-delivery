package com.kennedy.servicedelivery.application;

import com.kennedy.servicedelivery.core.exceptions.NotFoundException;
import com.kennedy.servicedelivery.core.models.Address;
import com.kennedy.servicedelivery.core.models.CoverageArea;
import com.kennedy.servicedelivery.core.models.Partner;
import com.kennedy.servicedelivery.core.usecases.FindPartnerByIdUseCase;
import com.kennedy.servicedelivery.core.utils.Util;
import com.kennedy.servicedelivery.db.repositories.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class FindPartnerByIdService implements FindPartnerByIdUseCase {

    private PartnerRepository repository;

    @Autowired
    public FindPartnerByIdService(PartnerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Partner findById(String id) {

        var entity = repository.findById(id).orElseThrow(() -> new NotFoundException("not found " + id));

        CoverageArea coverageArea = new CoverageArea();
        coverageArea.setType(entity.getTypeCoverageArea());
        coverageArea.getCoordinates().addAll(Util.convertDataCoordinatesCoverageAreaStringAsDouble(entity.getCoordinatesCoverageArea()));

        Address address = new Address();
        address.setType(entity.getTypeAddress());
        address.getCoordinates().addAll(Arrays.asList(entity.getLongitude(), entity.getLatitude()));

       return new Partner(
                entity.getId(),
                entity.getTradingName(),
                entity.getOwnerName(),
                entity.getDocument(),
                coverageArea,
                address
        );
    }
}
