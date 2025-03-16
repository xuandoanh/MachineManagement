package com.MachineManagement.controller;

import com.MachineManagement.dto.OperatorGroupDto;
import com.MachineManagement.service.OperatorGroupService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/operatorGroup")
public class OperatorGroupController {

    @Autowired
    private OperatorGroupService operatorGroupService;

    @PostMapping
    public ResponseEntity<OperatorGroupDto> addOperatorGroup(@RequestBody OperatorGroupDto operatorGroupDto) {
        OperatorGroupDto createdGroup = operatorGroupService.addOperatorGroup(operatorGroupDto);
        return ResponseEntity.ok(createdGroup);
    }

    @PutMapping("/{groupId}")
    public ResponseEntity<OperatorGroupDto> updateOperatorGroup(
            @PathVariable Long groupId, 
            @RequestBody OperatorGroupDto operatorGroupDto) {
        OperatorGroupDto updatedGroup = operatorGroupService.updateOperatorGroup(groupId, operatorGroupDto);
        return ResponseEntity.ok(updatedGroup);
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<OperatorGroupDto> getOperatorGroupById(@PathVariable Long groupId) {
        OperatorGroupDto operatorGroup = operatorGroupService.getOperatorGroupById(groupId);
        return ResponseEntity.ok(operatorGroup);
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<Void> deleteOperatorGroup(@PathVariable Long groupId) {
        operatorGroupService.deleteOperatorGroup(groupId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<OperatorGroupDto>> getAllOperatorGroups() {
        List<OperatorGroupDto> operatorGroups = operatorGroupService.getAllOperatorGroups();
        return ResponseEntity.ok(operatorGroups);
    }
}