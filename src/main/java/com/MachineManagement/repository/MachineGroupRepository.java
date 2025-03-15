package com.MachineManagement.repository;

import com.MachineManagement.entity.MachineGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineGroupRepository extends JpaRepository<MachineGroup, Long> {
}
