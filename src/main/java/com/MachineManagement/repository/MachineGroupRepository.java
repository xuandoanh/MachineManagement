package com.MachineManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MachineManagement.entity.MachineEntity.MachineGroupEntity;

@Repository
public interface MachineGroupRepository extends JpaRepository<MachineGroupEntity, Long> {
}
