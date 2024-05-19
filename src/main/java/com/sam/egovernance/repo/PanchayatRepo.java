package com.sam.egovernance.repo;

import com.sam.egovernance.entity.PanchayatDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanchayatRepo extends JpaRepository<PanchayatDetails,Integer> {
    PanchayatDetails findPanchayatDetailsByRequest(String request);
}
