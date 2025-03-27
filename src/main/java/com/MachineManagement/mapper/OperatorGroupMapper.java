package com.MachineManagement.mapper;

import com.MachineManagement.dto.OperatorDto.OperatorGroupDto;
import com.MachineManagement.entity.OperatorEntity.OperatorGroupEntity;

public class OperatorGroupMapper {
     public static OperatorGroupDto mapToDto(OperatorGroupEntity operatorGroup) {
        return new OperatorGroupDto(
                operatorGroup.getId(),
                operatorGroup.getGroupName(),
                operatorGroup.getOperators()
        );
    }

    public static OperatorGroupEntity mapToEntity(OperatorGroupDto operatorGroupDto) {
        return new OperatorGroupEntity(
            operatorGroupDto.getId(),
            operatorGroupDto.getGroupName(),
            operatorGroupDto.getOperators()
        );
    }
}
