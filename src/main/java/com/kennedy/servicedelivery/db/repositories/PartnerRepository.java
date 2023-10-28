package com.kennedy.servicedelivery.db.repositories;

import com.kennedy.servicedelivery.db.entities.PartnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartnerRepository extends JpaRepository<PartnerEntity, String> {

    List<PartnerEntity> findByLongitudeBetweenAndLatitudeBetweenOrderById(double minLongitude, double maxLongitude, double minLatitude, double maxLatitude);
}
