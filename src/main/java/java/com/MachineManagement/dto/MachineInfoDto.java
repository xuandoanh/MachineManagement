package java.com.MachineManagement.dto;

import java.com.MachineManagement.entity.MachineGroup;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MachineInfoDto {
    private Long machineId;
    private String machineName;
    private String machineType;
    private String machineGroupName;
    private String machineOffice;
    private MachineGroup machineGroup;
}
