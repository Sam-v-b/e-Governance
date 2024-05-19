package com.sam.egovernance.repo;

import com.sam.egovernance.entity.TalukDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TalukRepo extends JpaRepository<TalukDetails,Integer> {
    TalukDetails findTalukDetailsByRequest(String request);
}
