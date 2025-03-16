package com.MachineManagement.service;

import com.MachineManagement.dto.MachineDataDto;
import java.util.List;

public interface MachineDataService {
    
    MachineDataDto addMachineData(MachineDataDto machineDataDto);

    MachineDataDto updateMachineData(Long machineDateId, MachineDataDto machineDataDto);

    MachineDataDto getMachineDataById(Long id);

    void deleteMachineData(Long id);

    List<MachineDataDto> getAllMachineData();
}
