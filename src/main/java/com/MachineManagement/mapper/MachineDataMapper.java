package com.MachineManagement.mapper;

import com.MachineManagement.dto.MachineDataDto;
import com.MachineManagement.entity.MachineData;
import com.MachineManagement.entity.MachineInfo;
import com.MachineManagement.entity.OperatorInfo;

public class MachineDataMapper {

    public static MachineDataDto mapToDto(MachineData machineData) {
        return new MachineDataDto(
                machineData.getId(),
                machineData.getMachineInfo().getMachineId(),
                machineData.getDateSql(),
                machineData.getTimeSql(),
                machineData.getStatus(),
                machineData.getPower(),
                machineData.getOperatorInfo().getOperatorId(),
                machineData.getOrCode(),
                machineData.getDgCode(),
                machineData.getPgTime(),
                machineData.getPartNum(),
                machineData.getStep(),
                machineData.getPoint(),
                machineData.getBCode()
        );
    }

    public static MachineData mapToEntity(MachineDataDto machineDataDto, MachineInfo machineInfo, OperatorInfo operatorInfo) {
        return new MachineData(
                machineDataDto.getId(),
                machineInfo,
                machineDataDto.getDateSql(),
                machineDataDto.getTimeSql(),
                machineDataDto.getStatus(),
                machineDataDto.getPower(),
                operatorInfo,
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
