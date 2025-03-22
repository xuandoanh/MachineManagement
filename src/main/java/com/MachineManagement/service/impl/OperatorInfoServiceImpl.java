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
public class OperatorInfoServiceImpl implements OperatorInfoService {
    
    @Autowired
    private OperatorInfoRepository operatorInfoRepository;
    @Autowired
    private OperatorGroupRepository operatorGroupRepository;
    @Override
    public OperatorInfoDto addOperatorInfo(Long id, OperatorInfoDto operatorInfoDto) {
        // ✅ Ensure OperatorGroup exists before associating with OperatorInfo
        OperatorGroup operatorGroup = operatorGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Operator Group not found with id: " + id));
    
        // ✅ Create a new OperatorInfo and set properties
        OperatorInfo operatorInfo = new OperatorInfo();
        operatorInfo.setOperatorName(operatorInfoDto.getOperatorName());
        operatorInfo.setOperatorOffice(operatorInfoDto.getOperatorOffice());
        operatorInfo.setOperatorSection(operatorInfoDto.getOperatorSection());
        operatorInfo.setOperatorStep(operatorInfoDto.getOperatorStep());
    
        // ✅ Associate OperatorInfo with the correct OperatorGroup
        operatorInfo.setOperatorGroup(operatorGroup);
    
        // ✅ Save the OperatorInfo and return the DTO
        OperatorInfo savedOperatorInfo = operatorInfoRepository.save(operatorInfo);
        return OperatorInfoMapper.mapToDto(savedOperatorInfo);
    }

    @Override
    public OperatorInfoDto updateOperatorInfo(Long operatorId, OperatorInfoDto operatorInfoDto) {
        OperatorInfo operatorInfo = operatorInfoRepository.findById(operatorId)
                .orElseThrow(() -> new RuntimeException("Operator Info not found: " + operatorId));
        
        operatorInfo.setOperatorName(operatorInfoDto.getOperatorName());
        operatorInfo.setOperatorOffice(operatorInfoDto.getOperatorOffice());
        operatorInfo.setOperatorSection(operatorInfoDto.getOperatorSection());
        operatorInfo.setOperatorStep(operatorInfoDto.getOperatorStep());
        operatorInfo.setOperatorGroup(operatorInfoDto.getOperatorGroup());
        
        OperatorInfo updatedOperatorInfo = operatorInfoRepository.save(operatorInfo);
        return OperatorInfoMapper.mapToDto(updatedOperatorInfo);
    }

    @Override
    public OperatorInfoDto getOperatorInfoById(Long operatorId) {
        OperatorInfo operatorInfo = operatorInfoRepository.findById(operatorId)
                .orElseThrow(() -> new RuntimeException("Operator Info not found: " + operatorId));
        return OperatorInfoMapper.mapToDto(operatorInfo);
    }

    @Override
    public void deleteOperatorInfo(Long operatorId) {
        OperatorInfo operatorInfo = operatorInfoRepository.findById(operatorId)
                .orElseThrow(() -> new RuntimeException("Operator Info not found: " + operatorId));
        operatorInfoRepository.delete(operatorInfo);
    }

    @Override
    public List<OperatorInfoDto> getAllOperatorInfos() {
        List<OperatorInfo> operatorInfos = operatorInfoRepository.findAll();
        return operatorInfos.stream().map(OperatorInfoMapper::mapToDto).collect(Collectors.toList());
    }
}