package com.MachineManagement.mapper;

import com.MachineManagement.dto.MachineDto.MachineGroupDto;
import com.MachineManagement.entity.MachineEntity.MachineGroupEntity;

public class MachineGroupMapper {
    public static MachineGroupDto mapToDto(MachineGroupEntity machineGroup) {
        return new MachineGroupDto(
                machineGroup.getId(),
                machineGroup.getGroupName(),
                machineGroup.getMachines()
        );
    }

    public static MachineGroupEntity mapToEntity(MachineGroupDto machineGroupDto) {
        return new MachineGroupEntity(
            machineGroupDto.getId(),
            machineGroupDto.getGroupName(),
            machineGroupDto.getMachines()
        );
    }
}
