package java.com.MachineManagement.dto;

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
    private Long operatorGroupId;
}
