package com.MachineManagement.service.impl;

import com.MachineManagement.dto.MachineDataDto;
import com.MachineManagement.entity.MachineData;
import com.MachineManagement.entity.MachineInfo;
import com.MachineManagement.entity.OperatorInfo;
import com.MachineManagement.mapper.MachineDataMapper;
import com.MachineManagement.repository.MachineDataRepository;
import com.MachineManagement.repository.MachineInfoRepository;
import com.MachineManagement.repository.OperatorInfoRepository;
import com.MachineManagement.service.MachineDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MachineDataServiceImpl implements MachineDataService {

    @Autowired
    private MachineDataRepository machineDataRepository;

    @Override
    public MachineDataDto addMachineData(MachineDataDto machineDataDto) {
        MachineData machineData = MachineDataMapper.mapToEntity(machineDataDto);
        MachineData savedData = machineDataRepository.save(machineData);
        return MachineDataMapper.mapToDto(savedData);
    }

    @Override
    public MachineDataDto updateMachineData(Long id, MachineDataDto machineDataDto) {
        MachineData existingData = machineDataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MachineData not found"));
        existingData.setDateSql(machineDataDto.getDateSql());
        existingData.setTimeSql(machineDataDto.getTimeSql());
        existingData.setStatus(machineDataDto.getStatus());
        existingData.setPower(machineDataDto.getPower());
        existingData.setOrCode(machineDataDto.getOrCode());
        existingData.setDgCode(machineDataDto.getDgCode());
        existingData.setPgTime(machineDataDto.getPgTime());
        existingData.setPartNum(machineDataDto.getPartNum());
        existingData.setStep(machineDataDto.getStep());
        existingData.setPoint(machineDataDto.getPoint());
        existingData.setBCode(machineDataDto.getBCode());
        existingData.setMachineId(machineDataDto.getMachineId());
        existingData.setOperatorId(machineDataDto.getOperatorId());
        MachineData updatedData = machineDataRepository.save(existingData);
        return MachineDataMapper.mapToDto(updatedData);
    }

    @Override
    public MachineDataDto getMachineDataById(Long id) {
        MachineData machineData = machineDataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MachineData not found"));
        return MachineDataMapper.mapToDto(machineData);
    }

    @Override
    public void deleteMachineData(Long id) {
        if (!machineDataRepository.existsById(id)) {
            throw new RuntimeException("MachineData not found");
        }
        machineDataRepository.deleteById(id);
    }

    @Override
    public List<MachineDataDto> getAllMachineData() {
        List<MachineData> dataList = machineDataRepository.findAll();
        return dataList.stream()
                .map(MachineDataMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
