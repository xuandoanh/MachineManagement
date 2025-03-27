package com.MachineManagement.dto.MachineDto;

import lombok.*;
import java.time.LocalDateTime;

import com.MachineManagement.entity.MachineEntity.MachineInfoEntity;
import com.MachineManagement.entity.OperatorEntity.OperatorInfoEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MachineDataDto {
    private Long id;
    private MachineInfoEntity machineInfo;  
    private LocalDateTime datetimeSql; 
    private int status;
    private int power;
    private OperatorInfoEntity operatorInfo;
    private String orCode;
    private String dgCode; 
    private int pgTime;
    private int partNum;
    private int step;
    private int point;
    private String bCode;
}
