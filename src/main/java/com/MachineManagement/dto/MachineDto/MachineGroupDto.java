package com.MachineManagement.dto.MachineDto;

import lombok.*;

import java.util.List;

import com.MachineManagement.entity.MachineEntity.MachineInfoEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MachineGroupDto {
    private Long id;
    private String groupName;
    private List<MachineInfoEntity> machines; 
}
