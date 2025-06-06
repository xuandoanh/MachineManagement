package com.MachineManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MachineManagement.entity.OperatorEntity.OperatorGroupEntity;

@Repository
public interface OperatorGroupRepository extends JpaRepository<OperatorGroupEntity, Long> {
}
