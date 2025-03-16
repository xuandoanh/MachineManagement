package com.MachineManagement.service;

import com.MachineManagement.dto.*;
import java.util.List;



public interface OperatorInfoService {
    
    OperatorInfoDto addOperatorInfo(OperatorInfoDto operatorInfoDto);

    OperatorInfoDto updateOperatorInfo(Long operatorId, OperatorInfoDto operatorInfoDto);

    OperatorInfoDto getOperatorInfoById(Long operatorId);

    void deleteOperatorInfo(Long operatorId);

    List<OperatorInfoDto> getAllOperatorInfos();
}
