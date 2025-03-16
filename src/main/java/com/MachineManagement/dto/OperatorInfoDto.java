package com.MachineManagement.dto;

import java.util.List;

import com.MachineManagement.entity.MachineData;
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
    private List<MachineData> machineData;
}
