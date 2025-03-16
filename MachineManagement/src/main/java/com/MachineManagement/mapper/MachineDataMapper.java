package com.MachineManagement.mapper;

import com.MachineManagement.dto.MachineDataDto;
import com.MachineManagement.entity.MachineData;

public class MachineDataMapper {

    public static MachineDataDto mapToDto(MachineData machineData) {
        return new MachineDataDto(
                machineData.getId(),
                machineData.getMachineInfo(),
                machineData.getDateSql(),
                machineData.getTimeSql(),
                machineData.getStatus(),
                machineData.getPower(),
                machineData.getOpId(),
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
                machineDataDto.getMachineInfo(),
                machineDataDto.getDateSql(),
                machineDataDto.getTimeSql(),
                machineDataDto.getStatus(),
                machineDataDto.getPower(),
                machineDataDto.getOpId(),
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
