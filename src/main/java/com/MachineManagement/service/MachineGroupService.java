package com.MachineManagement.service;

import com.MachineManagement.dto.MachineGroupDto;
import java.util.List;

public interface MachineGroupService {
    
    MachineGroupDto addMachineGroup(MachineGroupDto machineGroupDto);

    MachineGroupDto updateMachineGroup(Long groupId, MachineGroupDto machineGroupDto);

    MachineGroupDto getMachineGroupById(Long groupId);

    void deleteMachineGroup(Long groupId);

    List<MachineGroupDto> getAllMachineGroups();
}
