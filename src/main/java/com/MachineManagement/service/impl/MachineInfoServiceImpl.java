package com.MachineManagement.service.impl;

import com.MachineManagement.dto.*;
import com.MachineManagement.entity.MachineInfo;
import com.MachineManagement.mapper.MachineInfoMapper;
import com.MachineManagement.repository.MachineInfoRepository;
import com.MachineManagement.service.MachineInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MachineInfoServiceImpl implements MachineInfoService {
    
    @Autowired
    private MachineInfoRepository machineInfoRepository;

    @Override
    public MachineInfoDto addMachineInfo(MachineInfoDto machineInfoDto) {
        MachineInfo machineInfo = MachineInfoMapper.mapToEntity(machineInfoDto);
        MachineInfo savedMachineInfo = machineInfoRepository.save(machineInfo);
        return MachineInfoMapper.mapToDto(savedMachineInfo);
    }

    @Override
    public MachineInfoDto updateMachineInfo(Long machineId, MachineInfoDto machineInfoDto) {
        MachineInfo machineInfo = machineInfoRepository.findById(machineId)
                .orElseThrow(() -> new RuntimeException("Machine Info not found: " + machineId));
        
        machineInfo.setMachineName(machineInfoDto.getMachineName());
        machineInfo.setMachineType(machineInfoDto.getMachineType());
        // Add additional field updates if necessary
        
        MachineInfo updatedMachineInfo = machineInfoRepository.save(machineInfo);
        return MachineInfoMapper.mapToDto(updatedMachineInfo);
    }

    @Override
    public MachineInfoDto getMachineInfoById(Long machineId) {
        MachineInfo machineInfo = machineInfoRepository.findById(machineId)
                .orElseThrow(() -> new RuntimeException("Machine Info not found: " + machineId));
        return MachineInfoMapper.mapToDto(machineInfo);
    }

    @Override
    public void deleteMachineInfo(Long machineId) {
        MachineInfo machineInfo = machineInfoRepository.findById(machineId)
                .orElseThrow(() -> new RuntimeException("Machine Info not found: " + machineId));
        machineInfoRepository.delete(machineInfo);
    }

    @Override
    public List<MachineInfoDto> getAllMachineInfos() {
        List<MachineInfo> machineInfos = machineInfoRepository.findAll();
        return machineInfos.stream().map(MachineInfoMapper::mapToDto).collect(Collectors.toList());
    }
}
