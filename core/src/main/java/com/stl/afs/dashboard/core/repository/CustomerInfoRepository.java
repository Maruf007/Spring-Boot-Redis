package com.stl.afs.dashboard.repository;

import com.stl.afs.dashboard.entity.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Long> {
    Optional<CustomerInfo> findByBranchCodeAndProcessDate(String branchCode, Date processDate);
}
