package com.MachineManagement.service.impl.MachineImpl;

import com.MachineManagement.dto.MachineDto.MachineGroupDto;
import com.MachineManagement.entity.MachineEntity.MachineGroupEntity;
import com.MachineManagement.service.MachineService.MachineGroupService;
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
        MachineGroupEntity machineGroup = MachineGroupMapper.mapToEntity(machineGroupDto);
        MachineGroupEntity savedMachineGroup = machineGroupRepository.save(machineGroup);
        return MachineGroupMapper.mapToDto(savedMachineGroup);
    }

    @Override
    public MachineGroupDto updateMachineGroup(Long groupId, MachineGroupDto machineGroupDto) {
        MachineGroupEntity machineGroup = machineGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Machine Group not found: " + groupId));
        
        machineGroup.setGroupName(machineGroupDto.getGroupName());
        // Add additional field updates here if necessary
        
        MachineGroupEntity updatedMachineGroup = machineGroupRepository.save(machineGroup);
        return MachineGroupMapper.mapToDto(updatedMachineGroup);
    }

    @Override
    public MachineGroupDto getMachineGroupById(Long groupId) {
        MachineGroupEntity machineGroup = machineGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Machine Group not found: " + groupId));
        return MachineGroupMapper.mapToDto(machineGroup);
    }

    @Override
    public void deleteMachineGroup(Long groupId) {
        MachineGroupEntity machineGroup = machineGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Machine Group not found: " + groupId));
        machineGroupRepository.delete(machineGroup);
    }

    @Override
    public List<MachineGroupDto> getAllMachineGroups() {
        List<MachineGroupEntity> machineGroups = machineGroupRepository.findAll();
        return machineGroups.stream().map(MachineGroupMapper::mapToDto).collect(Collectors.toList());
    }
}
