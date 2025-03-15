package com.MachineManagement.mapper;

import com.MachineManagement.dto.OperatorGroupDto;
import com.MachineManagement.entity.OperatorGroup;
import java.util.stream.Collectors;

public class OperatorGroupMapper {
     public static OperatorGroupDto mapToDto(OperatorGroup operatorGroup) {
        return new OperatorGroupDto(
                operatorGroup.getId(),
                operatorGroup.getGroupName(),
                operatorGroup.getOperators() != null ? operatorGroup.getOperators().stream()
                        .map(OperatorInfoMapper::mapToDto)
                        .collect(Collectors.toList()) : null
        );
    }

    public static OperatorGroup mapToEntity(OperatorGroupDto operatorGroupDto) {
        return new OperatorGroup(
            operatorGroupDto.getId(),
            operatorGroupDto.getGroupName(),
            operatorGroupDto.getOperators() != null ? operatorGroupDto.getOperators().stream()
                    .map(OperatorInfoMapper::mapToEntity)
                    .collect(Collectors.toList()) : null
        );
    }
}
