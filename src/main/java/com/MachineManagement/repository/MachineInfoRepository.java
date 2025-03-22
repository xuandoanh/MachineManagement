package com.MachineManagement.repository;

import com.MachineManagement.entity.MachineInfo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineInfoRepository extends JpaRepository<MachineInfo, Long> {
    List<MachineInfo> findByMachineGroupId(Long groupId);

}

