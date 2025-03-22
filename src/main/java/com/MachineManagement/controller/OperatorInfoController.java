package com.MachineManagement.controller;

import com.MachineManagement.dto.OperatorInfoDto;
import com.MachineManagement.service.OperatorInfoService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/operator")
public class OperatorInfoController {

    @Autowired
    private OperatorInfoService operatorInfoService;

    @PostMapping("/{id}")
    public ResponseEntity<OperatorInfoDto> addOperatorInfo(@PathVariable Long id, @RequestBody OperatorInfoDto operatorInfoDto) {
        OperatorInfoDto createdOperator = operatorInfoService.addOperatorInfo(id, operatorInfoDto);
        return ResponseEntity.ok(createdOperator);
    }

    @PutMapping("/{operatorId}")
    public ResponseEntity<OperatorInfoDto> updateOperatorInfo(
            @PathVariable Long operatorId, 
            @RequestBody OperatorInfoDto operatorInfoDto) {
        OperatorInfoDto updatedOperator = operatorInfoService.updateOperatorInfo(operatorId, operatorInfoDto);
        return ResponseEntity.ok(updatedOperator);
    }

    @GetMapping("/{operatorId}")
    public ResponseEntity<OperatorInfoDto> getOperatorInfoById(@PathVariable Long operatorId) {
        OperatorInfoDto operatorInfo = operatorInfoService.getOperatorInfoById(operatorId);
        return ResponseEntity.ok(operatorInfo);
    }

    @DeleteMapping("/{operatorId}")
    public ResponseEntity<Void> deleteOperatorInfo(@PathVariable Long operatorId) {
        operatorInfoService.deleteOperatorInfo(operatorId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<OperatorInfoDto>> getAllOperatorInfos() {
        List<OperatorInfoDto> operatorInfos = operatorInfoService.getAllOperatorInfos();
        return ResponseEntity.ok(operatorInfos);
    }
}