package com.MachineManagement.service.MachineService;

import java.util.List;

import com.MachineManagement.dto.MachineDto.MachineDataDto;


public interface MachineDataService {
    
    MachineDataDto addMachineData(MachineDataDto machineDataDto);

    MachineDataDto updateMachineData(Long machineDateId, MachineDataDto machineDataDto);

    MachineDataDto getMachineDataById(Long id);

    void deleteMachineData(Long id);

    List<MachineDataDto> getAllMachineData();

    List<MachineDataDto> getLatestStatusByGroup(Long id);
}
