package com.MachineManagement.mapper;

import com.MachineManagement.dto.MachineDataDto;
import com.MachineManagement.entity.MachineData;
public class MachineDataMapper {

    public static MachineDataDto mapToDto(MachineData machineData) {
        return new MachineDataDto(
                machineData.getId(),
                machineData.getMachineId(),
                machineData.getDateSql(),
                machineData.getTimeSql(),
                machineData.getStatus(),
                machineData.getPower(),
                machineData.getOperatorId(),
                machineData.getOrCode(),
                machineData.getDgCode(),
                machineData.getPgTime(),
                machineData.getPartNum(),
                machineData.getStep(),
                machineData.getPoint(),
                machineData.getBCode()
        );
    }

    public static MachineData mapToEntity(MachineDataDto machineDataDto) {
        return new MachineData(
                machineDataDto.getId(),
                machineDataDto.getMachineId(),
                machineDataDto.getDateSql(),
                machineDataDto.getTimeSql(),
                machineDataDto.getStatus(),
                machineDataDto.getPower(),
                machineDataDto.getOperatorId(),
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
