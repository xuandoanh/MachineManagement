package com.MachineManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;
import java.sql.Time;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MachineDataDto {

    private Long id;
    private Long machineId; // Keeping it as String to match your entity
    private Date dateSql;
    private Time timeSql;
    private int status;
    private int power;
    private Long operatorId;
    private String orCode;
    private String dgCode;
    private int pgTime;
    private int partNum;
    private int step;
    private int point;
    private String bCode;
}
