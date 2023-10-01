package com.kennedy.servicedelivery.application;

import com.kennedy.servicedelivery.core.dto.PartnerFormRequest;
import com.kennedy.servicedelivery.core.models.Partner;
import com.kennedy.servicedelivery.core.usecases.CreatePartnerUseCase;
import com.kennedy.servicedelivery.db.entities.PartnerEntity;
import com.kennedy.servicedelivery.db.repositories.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CreatePartnerService implements CreatePartnerUseCase {

    private PartnerRepository repository;

    @Autowired
    public CreatePartnerService(PartnerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createPartner(PartnerFormRequest form) {
        Partner partner = new Partner(form);
        String coordinatesCoverageArea = saveDataCoordinatesCoverageAreaString(form.coverageArea().getCoordinates());
        String coordinatesAddress = saveDataCoordinatesAddressString(form.address().getCoordinates());

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

    private String saveDataCoordinatesCoverageAreaString(List<List<List<List<Double>>>> coordinates) {

        List<List<Double>> listDataCoordinates = coordinates.get(0).get(0);
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < listDataCoordinates.size(); i++) {
            for (int j = 0; j < listDataCoordinates.get(i).size(); j++) {
                stringBuilder.append(listDataCoordinates.get(i).get(j));
                if (j != (coordinates.get(i).size() - 1)) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append(";");
        }

        return stringBuilder.toString();
    }

    private String saveDataCoordinatesAddressString(List<Double> coordinates) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < coordinates.size(); i++) {
            stringBuilder.append(coordinates.get(i));
            if (i != (coordinates.size() - 1)) {
                stringBuilder.append(",");
            } else {
                stringBuilder.append(";");
            }
        }

        return stringBuilder.toString();
    }

}
