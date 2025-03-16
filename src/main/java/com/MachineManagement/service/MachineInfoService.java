package com.MachineManagement.service;

import com.MachineManagement.dto.MachineInfoDto;
import java.util.List;

public interface MachineInfoService {
    
    MachineInfoDto addMachineInfo(Long groupMachineId,MachineInfoDto machineInfoDto);

    MachineInfoDto updateMachineInfo(Long machineId, MachineInfoDto machineInfoDto);

    MachineInfoDto getMachineInfoById(Long machineId);

    void deleteMachineInfo(Long machineId);

    List<MachineInfoDto> getAllMachineInfos();
    
}