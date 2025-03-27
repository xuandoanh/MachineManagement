package com.MachineManagement.service.impl.OperatorImpl;
import com.MachineManagement.dto.OperatorDto.OperatorInfoDto;
import com.MachineManagement.entity.OperatorEntity.OperatorGroupEntity;
import com.MachineManagement.entity.OperatorEntity.OperatorInfoEntity;
import com.MachineManagement.mapper.*;
import com.MachineManagement.repository.*;
import com.MachineManagement.service.OperatorService.OperatorInfoService;

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
        OperatorGroupEntity operatorGroup = operatorGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Operator Group not found with id: " + id));
    
        // ✅ Create a new OperatorInfo and set properties
        OperatorInfoEntity operatorInfo = new OperatorInfoEntity();
        operatorInfo.setOperatorName(operatorInfoDto.getOperatorName());
        operatorInfo.setOperatorOffice(operatorInfoDto.getOperatorOffice());
        operatorInfo.setOperatorSection(operatorInfoDto.getOperatorSection());
        operatorInfo.setOperatorStep(operatorInfoDto.getOperatorStep());
    
        // ✅ Associate OperatorInfo with the correct OperatorGroup
        operatorInfo.setOperatorGroup(operatorGroup);
    
        // ✅ Save the OperatorInfo and return the DTO
        OperatorInfoEntity savedOperatorInfo = operatorInfoRepository.save(operatorInfo);
        return OperatorInfoMapper.mapToDto(savedOperatorInfo);
    }

    @Override
    public OperatorInfoDto updateOperatorInfo(Long operatorId, OperatorInfoDto operatorInfoDto) {
        OperatorInfoEntity operatorInfo = operatorInfoRepository.findById(operatorId)
                .orElseThrow(() -> new RuntimeException("Operator Info not found: " + operatorId));
        
        operatorInfo.setOperatorName(operatorInfoDto.getOperatorName());
        operatorInfo.setOperatorOffice(operatorInfoDto.getOperatorOffice());
        operatorInfo.setOperatorSection(operatorInfoDto.getOperatorSection());
        operatorInfo.setOperatorStep(operatorInfoDto.getOperatorStep());
        operatorInfo.setOperatorGroup(operatorInfoDto.getOperatorGroup());
        
        OperatorInfoEntity updatedOperatorInfo = operatorInfoRepository.save(operatorInfo);
        return OperatorInfoMapper.mapToDto(updatedOperatorInfo);
    }

    @Override
    public OperatorInfoDto getOperatorInfoById(Long operatorId) {
        OperatorInfoEntity operatorInfo = operatorInfoRepository.findById(operatorId)
                .orElseThrow(() -> new RuntimeException("Operator Info not found: " + operatorId));
        return OperatorInfoMapper.mapToDto(operatorInfo);
    }

    @Override
    public void deleteOperatorInfo(Long operatorId) {
        OperatorInfoEntity operatorInfo = operatorInfoRepository.findById(operatorId)
                .orElseThrow(() -> new RuntimeException("Operator Info not found: " + operatorId));
        operatorInfoRepository.delete(operatorInfo);
    }

    @Override
    public List<OperatorInfoDto> getAllOperatorInfos() {
        List<OperatorInfoEntity> operatorInfos = operatorInfoRepository.findAll();
        return operatorInfos.stream().map(OperatorInfoMapper::mapToDto).collect(Collectors.toList());
    }
}