package com.MachineManagement.mapper;

import com.MachineManagement.dto.MachineDto.MachineInfoDto;
import com.MachineManagement.entity.MachineEntity.MachineInfoEntity;

public class MachineInfoMapper {
     public static MachineInfoDto mapToDto(MachineInfoEntity machineInfo) {
        return new MachineInfoDto(
                machineInfo.getMachineId(),
                machineInfo.getMachineName(),
                machineInfo.getMachineType(),
                machineInfo.getMachineGroupName(),
                machineInfo.getMachineOffice(),
                machineInfo.getMachineGroup()
        );
    }

    public static MachineInfoEntity mapToEntity(MachineInfoDto machineInfoDto) {
        return new MachineInfoEntity(
            machineInfoDto.getMachineId(),
            machineInfoDto.getMachineName(),
            machineInfoDto.getMachineType(),
            machineInfoDto.getMachineGroupName(),
            machineInfoDto.getMachineOffice(),
            machineInfoDto.getMachineGroup()
        );
    }
}
