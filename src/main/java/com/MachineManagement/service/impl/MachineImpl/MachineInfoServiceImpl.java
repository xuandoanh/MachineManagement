package com.MachineManagement.service.impl.MachineImpl;

import com.MachineManagement.dto.MachineDto.MachineInfoDto;
import com.MachineManagement.entity.MachineEntity.MachineGroupEntity;
import com.MachineManagement.entity.MachineEntity.MachineInfoEntity;
import com.MachineManagement.mapper.MachineInfoMapper;
import com.MachineManagement.repository.MachineGroupRepository;
import com.MachineManagement.repository.MachineInfoRepository;
import com.MachineManagement.service.MachineService.MachineInfoService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MachineInfoServiceImpl implements MachineInfoService {

    private final MachineInfoRepository machineInfoRepository;
    private final MachineGroupRepository machineGroupRepository;

    @Override
    public MachineInfoDto addMachineInfo(Long id, MachineInfoDto machineInfoDto) {
        // ✅ Ensure MachineGroup exists before associating with MachineInfo
        MachineGroupEntity machineGroup = machineGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Machine Group not found with id: " + id));

        // ✅ Create a new MachineInfo and set properties
        MachineInfoEntity machineInfo = new MachineInfoEntity();
        machineInfo.setMachineName(machineInfoDto.getMachineName());
        machineInfo.setMachineType(machineInfoDto.getMachineType());
        machineInfo.setMachineGroupName(machineInfoDto.getMachineGroupName());
        machineInfo.setMachineOffice(machineInfoDto.getMachineOffice());

        // ✅ Associate MachineInfo with the correct MachineGroup
        machineInfo.setMachineGroup(machineGroup);

        // ✅ Save the MachineInfo and return the DTO
        MachineInfoEntity savedMachineInfo = machineInfoRepository.save(machineInfo);
        return MachineInfoMapper.mapToDto(savedMachineInfo);
    }

    @Override
    public MachineInfoDto updateMachineInfo(Long machineId, MachineInfoDto machineInfoDto) {
        MachineInfoEntity machineInfo = machineInfoRepository.findById(machineId)
                .orElseThrow(() -> new RuntimeException("Machine Info not found: " + machineId));

        machineInfo.setMachineName(machineInfoDto.getMachineName());
        machineInfo.setMachineType(machineInfoDto.getMachineType());
        machineInfo.setMachineGroupName(machineInfoDto.getMachineGroupName());
        machineInfo.setMachineOffice(machineInfoDto.getMachineOffice());

        MachineInfoEntity updatedMachineInfo = machineInfoRepository.save(machineInfo);
        return MachineInfoMapper.mapToDto(updatedMachineInfo);
    }

    @Override
    public MachineInfoDto getMachineInfoById(Long machineId) {
        MachineInfoEntity machineInfo = machineInfoRepository.findById(machineId)
                .orElseThrow(() -> new RuntimeException("Machine Info not found: " + machineId));
        return MachineInfoMapper.mapToDto(machineInfo);
    }

    @Override
    public void deleteMachineInfo(Long machineId) {
        MachineInfoEntity machineInfo = machineInfoRepository.findById(machineId)
                .orElseThrow(() -> new RuntimeException("Machine Info not found: " + machineId));
        machineInfoRepository.delete(machineInfo);
    }

    @Override
    public List<MachineInfoDto> getAllMachineInfos() {
        return machineInfoRepository.findAll()
                .stream()
                .map(MachineInfoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
