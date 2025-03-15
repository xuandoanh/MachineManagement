package com.MachineManagement.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperatorGroupDto {
    private Long id;
    private String groupName;
    private List<OperatorInfoDto> operators;
} 