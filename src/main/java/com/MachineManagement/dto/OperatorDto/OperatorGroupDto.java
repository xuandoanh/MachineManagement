package com.MachineManagement.dto.OperatorDto;

import lombok.*;
import java.util.List;

import com.MachineManagement.entity.OperatorEntity.OperatorInfoEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperatorGroupDto {
    private Long id;
    private String groupName;
    private List<OperatorInfoEntity> operators;
} 