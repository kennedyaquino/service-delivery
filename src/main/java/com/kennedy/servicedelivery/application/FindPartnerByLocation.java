package com.kennedy.servicedelivery.application;

import com.kennedy.servicedelivery.core.models.Address;
import com.kennedy.servicedelivery.core.models.CoverageArea;
import com.kennedy.servicedelivery.core.models.Partner;
import com.kennedy.servicedelivery.core.usecases.FindPartnerByLocationUseCase;
import com.kennedy.servicedelivery.core.utils.Util;
import com.kennedy.servicedelivery.db.entities.PartnerEntity;
import com.kennedy.servicedelivery.db.repositories.PartnerRepository;

import java.util.Arrays;
import java.util.List;

public class FindPartnerByLocation implements FindPartnerByLocationUseCase {

    private PartnerRepository repository;

    public FindPartnerByLocation(PartnerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Partner findByLocation(double longitude, double latitude) {

        List<PartnerEntity> partnerEntities = repository.findByLongitudeBetweenAndLatitudeBetweenOrderById(
                longitude,
                longitude + 0.2,
                latitude,
                latitude + 0.2
        );

        //TODO: check if the list is empty, if so, search with new parameters

        double valueDistance = 0.0;
        int index = 0;

        for (int i = 0; i < partnerEntities.size(); i++) {
            double result = Util.calculateDistanceBetweenAddresses(longitude, latitude, partnerEntities.get(i).getLongitude(), partnerEntities.get(i).getLatitude());

            if (i == 0) {
                valueDistance = result;
            }

            if(result < valueDistance) {
                valueDistance = result;
                index = i;
            }
        }

        //TODO: check if the partner has a coverage area for the given location

        var entity = partnerEntities.get(index);

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
