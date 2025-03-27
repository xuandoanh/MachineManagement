package com.MachineManagement.service.MachineService;

import java.util.List;

import com.MachineManagement.dto.MachineDto.MachineInfoDto;

public interface MachineInfoService {
    
    MachineInfoDto addMachineInfo(Long groupMachineId,MachineInfoDto machineInfoDto);

    MachineInfoDto updateMachineInfo(Long machineId, MachineInfoDto machineInfoDto);

    MachineInfoDto getMachineInfoById(Long machineId);

    void deleteMachineInfo(Long machineId);

    List<MachineInfoDto> getAllMachineInfos();
    
}