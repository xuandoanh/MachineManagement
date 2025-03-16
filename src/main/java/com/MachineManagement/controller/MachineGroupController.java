package com.MachineManagement.controller;

import com.MachineManagement.dto.*;
import com.MachineManagement.service.*;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/machineGroup")
public class MachineGroupController {
    
    @Autowired
    private MachineGroupService machineGroupService;

    @PostMapping
    public ResponseEntity<MachineGroupDto> addMachineGroup(@RequestBody MachineGroupDto machineGroupDto) {
        MachineGroupDto createdGroup = machineGroupService.addMachineGroup(machineGroupDto);
        return ResponseEntity.ok(createdGroup);
    }

    @PutMapping("/{groupId}")
    public ResponseEntity<MachineGroupDto> updateMachineGroup(@PathVariable Long groupId, @RequestBody MachineGroupDto machineGroupDto) {
        MachineGroupDto updatedGroup = machineGroupService.updateMachineGroup(groupId, machineGroupDto);
        return ResponseEntity.ok(updatedGroup);
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<MachineGroupDto> getMachineGroupById(@PathVariable Long groupId) {
        MachineGroupDto group = machineGroupService.getMachineGroupById(groupId);
        return ResponseEntity.ok(group);
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<Void> deleteMachineGroup(@PathVariable Long groupId) {
        machineGroupService.deleteMachineGroup(groupId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<MachineGroupDto>> getAllMachineGroups() {
        List<MachineGroupDto> groups = machineGroupService.getAllMachineGroups();
        return ResponseEntity.ok(groups);
    }
}
