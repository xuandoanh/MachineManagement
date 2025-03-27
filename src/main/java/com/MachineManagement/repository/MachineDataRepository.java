package com.MachineManagement.repository;
import com.MachineManagement.entity.MachineEntity.MachineDataEntity;
import com.MachineManagement.entity.MachineEntity.MachineInfoEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineDataRepository extends JpaRepository<MachineDataEntity, Long> {
    List<MachineDataEntity> findByMachineInfoIn(List<MachineInfoEntity> machineInfos);
}
