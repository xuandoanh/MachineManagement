package java.com.MachineManagement.dto;

import lombok.*;

import java.com.MachineManagement.entity.MachineInfo;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MachineGroupDto {
    private Long id;
    private String groupName;
    private List<MachineInfo> machines; 
}
