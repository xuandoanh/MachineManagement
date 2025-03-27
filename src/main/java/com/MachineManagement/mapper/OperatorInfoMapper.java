package com.MachineManagement.mapper;

import com.MachineManagement.dto.OperatorDto.OperatorInfoDto;
import com.MachineManagement.entity.OperatorEntity.OperatorInfoEntity;

public class OperatorInfoMapper {
     public static OperatorInfoDto mapToDto(OperatorInfoEntity operatorInfo) {
        return new OperatorInfoDto(
                operatorInfo.getOperatorId(),
                operatorInfo.getOperatorName(),
                operatorInfo.getOperatorOffice(),
                operatorInfo.getOperatorSection(),
                operatorInfo.getOperatorStep(),
                operatorInfo.getOperatorGroup()
        );
    }

    public static OperatorInfoEntity mapToEntity(OperatorInfoDto operatorInfoDto) {
        return new OperatorInfoEntity(
            operatorInfoDto.getOperatorId(),
            operatorInfoDto.getOperatorName(),
            operatorInfoDto.getOperatorOffice(),
            operatorInfoDto.getOperatorSection(),
            operatorInfoDto.getOperatorStep(),
            operatorInfoDto.getOperatorGroup()
        );
    }
}
