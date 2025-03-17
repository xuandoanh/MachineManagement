package com.MachineManagement;

import com.MachineManagement.controller.MachineInfoController;
import com.MachineManagement.dto.MachineInfoDto;
import com.MachineManagement.service.MachineInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MachineInfoControllerTest {

    @Mock
    private MachineInfoService machineInfoService;

    @InjectMocks
    private MachineInfoController machineInfoController;

    private MachineInfoDto machineInfoDto;

    @BeforeEach
    void setUp() {
        machineInfoDto = new MachineInfoDto();
        machineInfoDto.setMachineId(1L);
        machineInfoDto.setMachineName("CNC Machine");
        machineInfoDto.setMachineType("Lathe");
        machineInfoDto.setMachineGroupName("Cutting Machines");
        machineInfoDto.setMachineOffice("Plant A");
    }

    @Test
    void testUpdateMachineInfo() {
        when(machineInfoService.updateMachineInfo(anyLong(), any())).thenReturn(machineInfoDto);

        ResponseEntity<MachineInfoDto> response = machineInfoController.updateMachineInfo(1L, machineInfoDto);

        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getMachineId());
        verify(machineInfoService, times(1)).updateMachineInfo(anyLong(), any());
    }

    @Test
    void testGetMachineInfoById() {
        when(machineInfoService.getMachineInfoById(1L)).thenReturn(machineInfoDto);

        ResponseEntity<MachineInfoDto> response = machineInfoController.getMachineInfoById(1L);

        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getMachineId());
        verify(machineInfoService, times(1)).getMachineInfoById(1L);
    }

    @Test
    void testDeleteMachineInfo() {
        doNothing().when(machineInfoService).deleteMachineInfo(1L);

        ResponseEntity<Void> response = machineInfoController.deleteMachineInfo(1L);

        assertEquals(204, response.getStatusCodeValue());
        verify(machineInfoService, times(1)).deleteMachineInfo(1L);
    }

    @Test
    void testGetAllMachineInfos() {
        List<MachineInfoDto> machineList = Arrays.asList(machineInfoDto);
        when(machineInfoService.getAllMachineInfos()).thenReturn(machineList);

        ResponseEntity<List<MachineInfoDto>> response = machineInfoController.getAllMachineInfos();

        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        verify(machineInfoService, times(1)).getAllMachineInfos();
    }
}
