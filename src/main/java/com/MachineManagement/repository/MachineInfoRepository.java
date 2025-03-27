package com.MachineManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MachineManagement.entity.MachineEntity.MachineInfoEntity;

@Repository
public interface MachineInfoRepository extends JpaRepository<MachineInfoEntity, Long> {
    List<MachineInfoEntity> findByMachineGroupId(Long groupId);

}

