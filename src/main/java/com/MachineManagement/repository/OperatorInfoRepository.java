package com.MachineManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MachineManagement.entity.OperatorEntity.OperatorInfoEntity;


@Repository
public interface OperatorInfoRepository extends JpaRepository<OperatorInfoEntity, Long> {
}


