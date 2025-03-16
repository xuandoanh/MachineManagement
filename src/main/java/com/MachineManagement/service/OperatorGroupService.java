package com.MachineManagement.service;

import com.MachineManagement.dto.*;
import java.util.List;


public interface OperatorGroupService {
    
    OperatorGroupDto addOperatorGroup(OperatorGroupDto operatorGroupDto);

    OperatorGroupDto updateOperatorGroup(Long groupId, OperatorGroupDto operatorGroupDto);

    OperatorGroupDto getOperatorGroupById(Long groupId);

    void deleteOperatorGroup(Long groupId);

    List<OperatorGroupDto> getAllOperatorGroups();
}