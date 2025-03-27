package com.MachineManagement.mapper;

import com.MachineManagement.dto.MachineDto.MachineDataDto;
import com.MachineManagement.entity.MachineEntity.MachineDataEntity;
public class MachineDataMapper {

    public static MachineDataDto mapToDto(MachineDataEntity machineData) {
        return new MachineDataDto(
                machineData.getId(),
                machineData.getMachineInfo(),
                machineData.getDatetimeSql(),
                machineData.getStatus(),
                machineData.getPower(),
                machineData.getOperatorInfo(),
                machineData.getOrCode(),
                machineData.getDgCode(),
                machineData.getPgTime(),
                machineData.getPartNum(),
                machineData.getStep(),
                machineData.getPoint(),
                machineData.getBCode()
        );
    }

    public static MachineDataEntity mapToEntity(MachineDataDto machineDataDto) {
        return new MachineDataEntity(
                machineDataDto.getId(),
                machineDataDto.getMachineInfo(),
                machineDataDto.getDatetimeSql(),
                machineDataDto.getStatus(),
                machineDataDto.getPower(),
                machineDataDto.getOperatorInfo(),
                machineDataDto.getOrCode(),
                machineDataDto.getDgCode(),
                machineDataDto.getPgTime(),
                machineDataDto.getPartNum(),
                machineDataDto.getStep(),
                machineDataDto.getPoint(),
                machineDataDto.getBCode()
        );
    }
}
