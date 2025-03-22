package com.MachineManagement.repository;

import com.MachineManagement.entity.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineDataRepository extends JpaRepository<MachineData, Long> {
    List<MachineData> findByMachineInfoIn(List<MachineInfo> machineInfos);
}
