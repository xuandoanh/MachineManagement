package com.MachineManagement.service.impl.OperatorImpl;

import com.MachineManagement.dto.OperatorDto.OperatorGroupDto;
import com.MachineManagement.entity.OperatorEntity.OperatorGroupEntity;
import com.MachineManagement.mapper.*;
import com.MachineManagement.repository.*;
import com.MachineManagement.service.OperatorService.OperatorGroupService;

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
        OperatorGroupEntity operatorGroup = OperatorGroupMapper.mapToEntity(operatorGroupDto);
        OperatorGroupEntity savedOperatorGroup = operatorGroupRepository.save(operatorGroup);
        return OperatorGroupMapper.mapToDto(savedOperatorGroup);
    }

    @Override
    public OperatorGroupDto updateOperatorGroup(Long groupId, OperatorGroupDto operatorGroupDto) {
        OperatorGroupEntity operatorGroup = operatorGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Operator Group not found: " + groupId));
        
        operatorGroup.setGroupName(operatorGroupDto.getGroupName());   
        OperatorGroupEntity updatedOperatorGroup = operatorGroupRepository.save(operatorGroup);
        return OperatorGroupMapper.mapToDto(updatedOperatorGroup);
    }

    @Override
    public OperatorGroupDto getOperatorGroupById(Long groupId) {
        OperatorGroupEntity operatorGroup = operatorGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Operator Group not found: " + groupId));
        return OperatorGroupMapper.mapToDto(operatorGroup);
    }

    @Override
    public void deleteOperatorGroup(Long groupId) {
        OperatorGroupEntity operatorGroup = operatorGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Operator Group not found: " + groupId));
        operatorGroupRepository.delete(operatorGroup);
    }

    @Override
    public List<OperatorGroupDto> getAllOperatorGroups() {
        List<OperatorGroupEntity> operatorGroups = operatorGroupRepository.findAll();
        return operatorGroups.stream().map(OperatorGroupMapper::mapToDto).collect(Collectors.toList());
    }
}
