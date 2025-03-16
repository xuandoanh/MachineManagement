package com.MachineManagement.service.impl;

import com.MachineManagement.dto.*;
import com.MachineManagement.entity.*;
import com.MachineManagement.mapper.*;
import com.MachineManagement.repository.*;
import com.MachineManagement.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperatorGroupServiceImpl implements OperatorGroupService {
    
    @Autowired
    private OperatorGroupRepository operatorGroupRepository;

    @Override
    public OperatorGroupDto addOperatorGroup(OperatorGroupDto operatorGroupDto) {
        OperatorGroup operatorGroup = OperatorGroupMapper.mapToEntity(operatorGroupDto);
        OperatorGroup savedOperatorGroup = operatorGroupRepository.save(operatorGroup);
        return OperatorGroupMapper.mapToDto(savedOperatorGroup);
    }

    @Override
    public OperatorGroupDto updateOperatorGroup(Long groupId, OperatorGroupDto operatorGroupDto) {
        OperatorGroup operatorGroup = operatorGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Operator Group not found: " + groupId));
        
        operatorGroup.setGroupName(operatorGroupDto.getGroupName());
        operatorGroup.setOperators(operatorGroupDto.getOperators().stream()
                .map(OperatorInfoMapper::mapToEntity)
                .collect(Collectors.toList()));
        
        OperatorGroup updatedOperatorGroup = operatorGroupRepository.save(operatorGroup);
        return OperatorGroupMapper.mapToDto(updatedOperatorGroup);
    }

    @Override
    public OperatorGroupDto getOperatorGroupById(Long groupId) {
        OperatorGroup operatorGroup = operatorGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Operator Group not found: " + groupId));
        return OperatorGroupMapper.mapToDto(operatorGroup);
    }

    @Override
    public void deleteOperatorGroup(Long groupId) {
        OperatorGroup operatorGroup = operatorGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Operator Group not found: " + groupId));
        operatorGroupRepository.delete(operatorGroup);
    }

    @Override
    public List<OperatorGroupDto> getAllOperatorGroups() {
        List<OperatorGroup> operatorGroups = operatorGroupRepository.findAll();
        return operatorGroups.stream().map(OperatorGroupMapper::mapToDto).collect(Collectors.toList());
    }
}
