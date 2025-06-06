package com.MachineManagement.controller.MachineController;

import com.MachineManagement.dto.MachineDto.MachineInfoDto;
import com.MachineManagement.service.MachineService.MachineInfoService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/machine")
public class MachineInfoController {

    @Autowired
    private MachineInfoService machineInfoService;

    @PostMapping("/{id}")
    public ResponseEntity<MachineInfoDto> addMachineInfo(@PathVariable Long id, @RequestBody MachineInfoDto machineInfoDto) {
        MachineInfoDto createdMachine = machineInfoService.addMachineInfo(id, machineInfoDto);
        return ResponseEntity.ok(createdMachine);
    }

    @PutMapping("/{machineId}")
    public ResponseEntity<MachineInfoDto> updateMachineInfo(
            @PathVariable Long machineId, 
            @RequestBody MachineInfoDto machineInfoDto) {
        MachineInfoDto updatedMachine = machineInfoService.updateMachineInfo(machineId, machineInfoDto);
        return ResponseEntity.ok(updatedMachine);
    }

    @GetMapping("/{machineId}")
    public ResponseEntity<MachineInfoDto> getMachineInfoById(@PathVariable Long machineId) {
        MachineInfoDto machineInfo = machineInfoService.getMachineInfoById(machineId);
        return ResponseEntity.ok(machineInfo);
    }

    @DeleteMapping("/{machineId}")
    public ResponseEntity<Void> deleteMachineInfo(@PathVariable Long machineId) {
        machineInfoService.deleteMachineInfo(machineId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<MachineInfoDto>> getAllMachineInfos() {
        List<MachineInfoDto> machineInfos = machineInfoService.getAllMachineInfos();
        return ResponseEntity.ok(machineInfos);
    }
}
