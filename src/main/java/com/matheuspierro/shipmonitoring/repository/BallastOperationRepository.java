package com.matheuspierro.shipmonitoring.repository;

import com.matheuspierro.shipmonitoring.model.BallastOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BallastOperationRepository extends JpaRepository<BallastOperation, Long> {
}

