package com.MachineManagement.service.impl.MachineImpl;

import com.MachineManagement.dto.MachineDto.MachineDataDto;
import com.MachineManagement.entity.MachineEntity.MachineDataEntity;
import com.MachineManagement.entity.MachineEntity.MachineInfoEntity;
import com.MachineManagement.entity.OperatorEntity.OperatorInfoEntity;
import com.MachineManagement.mapper.MachineDataMapper;
import com.MachineManagement.repository.MachineDataRepository;
import com.MachineManagement.repository.MachineInfoRepository;
import com.MachineManagement.service.MachineService.MachineDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MachineDataServiceImpl implements MachineDataService {

    @Autowired
    private MachineDataRepository machineDataRepository;

    @Autowired
    private MachineInfoRepository machineInfoRepository;

    @Override
    public MachineDataDto addMachineData(MachineDataDto machineDataDto) {
        MachineDataEntity machineData = MachineDataMapper.mapToEntity(machineDataDto);
        MachineDataEntity savedData = machineDataRepository.save(machineData);
        return MachineDataMapper.mapToDto(savedData);
    }

    @Override
    public MachineDataDto updateMachineData(Long id, MachineDataDto machineDataDto) {
        MachineDataEntity existingData = machineDataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MachineData not found"));

        // Set all primitive and simple fields
        existingData.setDatetimeSql(machineDataDto.getDatetimeSql());
        existingData.setStatus(machineDataDto.getStatus());
        existingData.setPower(machineDataDto.getPower());
        existingData.setOrCode(machineDataDto.getOrCode());
        existingData.setDgCode(machineDataDto.getDgCode());
        existingData.setPgTime(machineDataDto.getPgTime());
        existingData.setPartNum(machineDataDto.getPartNum());
        existingData.setStep(machineDataDto.getStep());
        existingData.setPoint(machineDataDto.getPoint());
        existingData.setBCode(machineDataDto.getBCode());

        // Handle MachineInfo separately to avoid object mismatch
        MachineInfoEntity machineInfo = new MachineInfoEntity();
        machineInfo.setMachineId(machineDataDto.getMachineInfo().getMachineId());
        machineInfo.setMachineName(machineDataDto.getMachineInfo().getMachineName());
        existingData.setMachineInfo(machineInfo);

        // Handle OperatorInfo separately
        OperatorInfoEntity operatorInfo = new OperatorInfoEntity();
        operatorInfo.setOperatorId(machineDataDto.getOperatorInfo().getOperatorId());
        operatorInfo.setOperatorName(machineDataDto.getOperatorInfo().getOperatorName());
        existingData.setOperatorInfo(operatorInfo);

        // Save and return updated data
        MachineDataEntity updatedData = machineDataRepository.save(existingData);
        return MachineDataMapper.mapToDto(updatedData);
    }

    @Override
    public MachineDataDto getMachineDataById(Long id) {
        MachineDataEntity machineData = machineDataRepository.findById(id)
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
        List<MachineDataEntity> dataList = machineDataRepository.findAll();
        return dataList.stream()
                .map(MachineDataMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MachineDataDto> getLatestStatusByGroup(Long groupId) {
        // Step 1: Find all MachineInfo objects in the given group
        List<MachineInfoEntity> machines = machineInfoRepository.findByMachineGroupId(groupId);

        if (machines.isEmpty()) {
            return Collections.emptyList(); // No machines found in the group
        }

        // Step 2: Get all machine data for these machine IDs
        List<MachineDataEntity> allMachineData = machineDataRepository.findByMachineInfoIn(machines);

        // Step 3: Find the latest status for each machine
        Map<Long, MachineDataEntity> latestStatusMap = allMachineData.stream()
                .collect(Collectors.toMap(
                        data -> (Long) data.getMachineInfo().getMachineId(), // Explicitly cast to Long
                        Function.identity(),
                        (existing, replacement) -> existing.getDatetimeSql()
                                .isAfter(replacement.getDatetimeSql()) ? existing : replacement));

        // Step 4: Convert to DTOs and return
        return latestStatusMap.values().stream()
                .map(MachineDataMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
