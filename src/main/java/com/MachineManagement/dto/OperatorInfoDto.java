package com.MachineManagement.dto;

import com.MachineManagement.entity.OperatorGroup;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperatorInfoDto {
    private Long operatorId;
    private String operatorName;
    private String operatorOffice;
    private String operatorSection;
    private String operatorStep;
    private OperatorGroup operatorGroup;
}
