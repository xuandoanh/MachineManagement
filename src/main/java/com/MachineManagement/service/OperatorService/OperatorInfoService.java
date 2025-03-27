package com.MachineManagement.service.OperatorService;
import com.MachineManagement.dto.OperatorDto.OperatorInfoDto;

import java.util.List;



public interface OperatorInfoService {
    
    OperatorInfoDto addOperatorInfo(Long id, OperatorInfoDto operatorInfoDto);

    OperatorInfoDto updateOperatorInfo(Long operatorId, OperatorInfoDto operatorInfoDto);

    OperatorInfoDto getOperatorInfoById(Long operatorId);

    void deleteOperatorInfo(Long operatorId);

    List<OperatorInfoDto> getAllOperatorInfos();
}
