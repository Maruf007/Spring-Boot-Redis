package com.stl.afs.dashboard.repository;

import com.stl.afs.dashboard.entity.ActiveBorrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface ActiveBorrowerRepository extends JpaRepository<ActiveBorrower, Long> {
    public Optional<ActiveBorrower> findByBranchCodeAndProcessDate(String branchCode, Date processDate);
}
