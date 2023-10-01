package com.kennedy.servicedelivery.db.repositories;

import com.kennedy.servicedelivery.db.entities.PartnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<PartnerEntity, String> {
}
