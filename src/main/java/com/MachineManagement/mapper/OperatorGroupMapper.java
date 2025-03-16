package com.MachineManagement.mapper;

import com.MachineManagement.dto.OperatorGroupDto;
import com.MachineManagement.entity.OperatorGroup;

public class OperatorGroupMapper {
     public static OperatorGroupDto mapToDto(OperatorGroup operatorGroup) {
        return new OperatorGroupDto(
                operatorGroup.getId(),
                operatorGroup.getGroupName(),
                operatorGroup.getOperators()
        );
    }

    public static OperatorGroup mapToEntity(OperatorGroupDto operatorGroupDto) {
        return new OperatorGroup(
            operatorGroupDto.getId(),
            operatorGroupDto.getGroupName(),
            operatorGroupDto.getOperators()
        );
    }
}
