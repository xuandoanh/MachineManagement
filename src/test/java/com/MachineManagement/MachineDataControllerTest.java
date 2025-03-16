package com.MachineManagement;

import com.MachineManagement.controller.MachineDataController;
import com.MachineManagement.dto.MachineDataDto;
import com.MachineManagement.service.MachineDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MachineDataControllerTest {

    private MockMvc mockMvc;

    @Mock
    private MachineDataService machineDataService;

    @InjectMocks
    private MachineDataController machineDataController;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(machineDataController).build();
    }

    @Test
    public void testAddMachineData() throws Exception {
        MachineDataDto machineDataDto = new MachineDataDto();
        when(machineDataService.addMachineData(any())).thenReturn(machineDataDto);

        mockMvc.perform(post("/api/machineData")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(machineDataDto)))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateMachineData() throws Exception {
        MachineDataDto machineDataDto = new MachineDataDto();
        when(machineDataService.updateMachineData(anyLong(), any())).thenReturn(machineDataDto);

        mockMvc.perform(put("/api/machineData/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(machineDataDto)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetMachineDataById() throws Exception {
        MachineDataDto machineDataDto = new MachineDataDto();
        when(machineDataService.getMachineDataById(anyLong())).thenReturn(machineDataDto);

        mockMvc.perform(get("/api/machineData/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteMachineData() throws Exception {
        doNothing().when(machineDataService).deleteMachineData(anyLong());

        mockMvc.perform(delete("/api/machineData/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testGetAllMachineData() throws Exception {
        List<MachineDataDto> machineDataList = Arrays.asList(new MachineDataDto(), new MachineDataDto());
        when(machineDataService.getAllMachineData()).thenReturn(machineDataList);

        mockMvc.perform(get("/api/machineData"))
                .andExpect(status().isOk());
    }
}
