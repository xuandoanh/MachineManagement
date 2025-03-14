package java.com.MachineManagement.mapper;

import java.com.MachineManagement.dto.MachineGroupDto;
import java.com.MachineManagement.entity.MachineGroup;

public class MachineGroupMapper {
    public static MachineGroupDto mapToDto(MachineGroup machineGroup) {
        return new MachineGroupDto(
                machineGroup.getId(),
                machineGroup.getGroupName(),
                machineGroup.getMachines()
        );
    }

    public static MachineGroup mapToEntity(MachineGroupDto machineGroupDto) {
        return new MachineGroup(
            machineGroupDto.getId(),
            machineGroupDto.getGroupName(),
            machineGroupDto.getMachines()
        );
    }
}
