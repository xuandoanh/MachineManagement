
package com.MachineManagement.dto.MachineDto;
import com.MachineManagement.entity.MachineEntity.MachineGroupEntity;

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
    private MachineGroupEntity machineGroup;
}
