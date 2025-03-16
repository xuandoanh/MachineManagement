package com.MachineManagement.controller;

import com.MachineManagement.dto.MachineInfoDto;
import com.MachineManagement.service.MachineInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/machine")
public class MachineInfoController {

    @Autowired
    private MachineInfoService machineInfoService;

    @PostMapping
    public ResponseEntity<MachineInfoDto> addMachineInfo(@RequestBody MachineInfoDto machineInfoDto) {
        MachineInfoDto createdMachine = machineInfoService.addMachineInfo(machineInfoDto);
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
