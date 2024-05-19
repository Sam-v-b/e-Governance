package com.sam.egovernance.repo;

import com.sam.egovernance.entity.DistrictDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepo extends JpaRepository<DistrictDetails, Integer> {
    DistrictDetails findDistrictDetailsByRequest(String request);
}
