package com.MachineManagement.service.OperatorService;

import com.MachineManagement.dto.OperatorDto.OperatorGroupDto;

import java.util.List;


public interface OperatorGroupService {
    
    OperatorGroupDto addOperatorGroup(OperatorGroupDto operatorGroupDto);

    OperatorGroupDto updateOperatorGroup(Long groupId, OperatorGroupDto operatorGroupDto);

    OperatorGroupDto getOperatorGroupById(Long groupId);

    void deleteOperatorGroup(Long groupId);

    List<OperatorGroupDto> getAllOperatorGroups();
}