package com.MachineManagement.mapper;

import com.MachineManagement.dto.OperatorInfoDto;
import com.MachineManagement.entity.OperatorInfo;

public class OperatorInfoMapper {
     public static OperatorInfoDto mapToDto(OperatorInfo operatorInfo) {
        return new OperatorInfoDto(
                operatorInfo.getOperatorId(),
                operatorInfo.getOperatorName(),
                operatorInfo.getOperatorOffice(),
                operatorInfo.getOperatorSection(),
                operatorInfo.getOperatorStep(),
                operatorInfo.getOperatorGroup()
        );
    }

    public static OperatorInfo mapToEntity(OperatorInfoDto operatorInfoDto) {
        return new OperatorInfo(
            operatorInfoDto.getOperatorId(),
            operatorInfoDto.getOperatorName(),
            operatorInfoDto.getOperatorOffice(),
            operatorInfoDto.getOperatorSection(),
            operatorInfoDto.getOperatorStep(),
            operatorInfoDto.getOperatorGroup()
        );
    }
}
