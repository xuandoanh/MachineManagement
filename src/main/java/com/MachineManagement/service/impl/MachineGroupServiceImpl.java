package com.MachineManagement.service.impl;

import com.MachineManagement.dto.*;
import com.MachineManagement.entity.*;
import com.MachineManagement.service.*;
import com.MachineManagement.repository.*;
import com.MachineManagement.mapper.*;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MachineGroupServiceImpl implements MachineGroupService {
    
    @Autowired
    private MachineGroupRepository machineGroupRepository;

    @Override
    public MachineGroupDto addMachineGroup(MachineGroupDto machineGroupDto) {
        MachineGroup machineGroup = MachineGroupMapper.mapToEntity(machineGroupDto);
        MachineGroup savedMachineGroup = machineGroupRepository.save(machineGroup);
        return MachineGroupMapper.mapToDto(savedMachineGroup);
    }

    @Override
    public MachineGroupDto updateMachineGroup(Long groupId, MachineGroupDto machineGroupDto) {
        MachineGroup machineGroup = machineGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Machine Group not found: " + groupId));
        
        machineGroup.setGroupName(machineGroupDto.getGroupName());
        // Add additional field updates here if necessary
        
        MachineGroup updatedMachineGroup = machineGroupRepository.save(machineGroup);
        return MachineGroupMapper.mapToDto(updatedMachineGroup);
    }

    @Override
    public MachineGroupDto getMachineGroupById(Long groupId) {
        MachineGroup machineGroup = machineGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Machine Group not found: " + groupId));
        return MachineGroupMapper.mapToDto(machineGroup);
    }

    @Override
    public void deleteMachineGroup(Long groupId) {
        MachineGroup machineGroup = machineGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Machine Group not found: " + groupId));
        machineGroupRepository.delete(machineGroup);
    }

    @Override
    public List<MachineGroupDto> getAllMachineGroups() {
        List<MachineGroup> machineGroups = machineGroupRepository.findAll();
        return machineGroups.stream().map(MachineGroupMapper::mapToDto).collect(Collectors.toList());
    }
}
