package com.MachineManagement.controller;

import com.MachineManagement.dto.MachineDataDto;
import com.MachineManagement.service.MachineDataService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/machineData")
public class MachineDataController {

    @Autowired
    private MachineDataService machineDataService;

    @PostMapping
    public ResponseEntity<MachineDataDto> addMachineData(@RequestBody MachineDataDto machineDataDto) {
        MachineDataDto createdData = machineDataService.addMachineData(machineDataDto);
        return ResponseEntity.ok(createdData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MachineDataDto> updateMachineData(
            @PathVariable Long id, 
            @RequestBody MachineDataDto machineDataDto) {
        MachineDataDto updatedData = machineDataService.updateMachineData(id, machineDataDto);
        return ResponseEntity.ok(updatedData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MachineDataDto> getMachineDataById(@PathVariable Long id) {
        MachineDataDto machineData = machineDataService.getMachineDataById(id);
        return ResponseEntity.ok(machineData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMachineData(@PathVariable Long id) {
        machineDataService.deleteMachineData(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<MachineDataDto>> getAllMachineData() {
        List<MachineDataDto> machineDataList = machineDataService.getAllMachineData();
        return ResponseEntity.ok(machineDataList);
    }
}
