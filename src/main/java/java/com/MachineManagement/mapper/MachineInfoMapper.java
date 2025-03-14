package java.com.MachineManagement.mapper;

import java.com.MachineManagement.dto.MachineInfoDto;
import java.com.MachineManagement.entity.MachineInfo;

public class MachineInfoMapper {
     public static MachineInfoDto mapToDto(MachineInfo machineInfo) {
        return new MachineInfoDto(
                machineInfo.getMachineId(),
                machineInfo.getMachineName(),
                machineInfo.getMachineType(),
                machineInfo.getMachineGroupName(),
                machineInfo.getMachineOffice(),
                machineInfo.getMachineGroup()
        );
    }

    public static MachineInfo mapToEntity(MachineInfoDto machineInfoDto) {
        return new MachineInfo(
            machineInfoDto.getMachineId(),
            machineInfoDto.getMachineName(),
            machineInfoDto.getMachineType(),
            machineInfoDto.getMachineGroupName(),
            machineInfoDto.getMachineOffice(),
            machineInfoDto.getMachineGroup()
        );
    }
}
