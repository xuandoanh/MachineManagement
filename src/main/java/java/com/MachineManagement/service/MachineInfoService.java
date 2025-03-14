package java.com.MachineManagement.service;

import java.com.MachineManagement.dto.MachineInfoDto;
import java.util.List;

public interface MachineInfoService {
    
    MachineInfoDto addMachineInfo(MachineInfoDto machineInfoDto);

    MachineInfoDto updateMachineInfo(Long machineId, MachineInfoDto machineInfoDto);

    MachineInfoDto getMachineInfoById(Long machineId);

    void deleteMachineInfo(Long machineId);

    List<MachineInfoDto> getAllMachineInfos();
    
}