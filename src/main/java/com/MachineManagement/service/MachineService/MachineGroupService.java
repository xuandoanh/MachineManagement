package com.MachineManagement.service.MachineService;

import java.util.List;

import com.MachineManagement.dto.MachineDto.MachineGroupDto;

public interface MachineGroupService {
    
    MachineGroupDto addMachineGroup(MachineGroupDto machineGroupDto);

    MachineGroupDto updateMachineGroup(Long groupId, MachineGroupDto machineGroupDto);

    MachineGroupDto getMachineGroupById(Long groupId);

    void deleteMachineGroup(Long groupId);

    List<MachineGroupDto> getAllMachineGroups();
}
