package com.MachineManagement.dto;

import lombok.*;
import java.time.LocalDateTime;

import com.MachineManagement.entity.MachineInfo;
import com.MachineManagement.entity.OperatorInfo;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MachineDataDto {
    private Long id;
    private MachineInfo machineInfo;  
    private LocalDateTime datetimeSql; 
    private int status;
    private int power;
    private OperatorInfo operatorInfo;
    private String orCode;
    private String dgCode; 
    private int pgTime;
    private int partNum;
    private int step;
    private int point;
    private String bCode;
}
