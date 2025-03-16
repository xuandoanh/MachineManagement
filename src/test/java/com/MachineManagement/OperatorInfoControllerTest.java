package com.MachineManagement;

import com.MachineManagement.controller.OperatorInfoController;
import com.MachineManagement.dto.OperatorInfoDto;
import com.MachineManagement.service.OperatorInfoService;
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
public class OperatorInfoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private OperatorInfoService operatorInfoService;

    @InjectMocks
    private OperatorInfoController operatorInfoController;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(operatorInfoController).build();
    }

    @Test
    public void testAddOperatorInfo() throws Exception {
        OperatorInfoDto operatorInfoDto = new OperatorInfoDto();
        when(operatorInfoService.addOperatorInfo(any())).thenReturn(operatorInfoDto);

        mockMvc.perform(post("/api/operator")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(operatorInfoDto)))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateOperatorInfo() throws Exception {
        OperatorInfoDto operatorInfoDto = new OperatorInfoDto();
        when(operatorInfoService.updateOperatorInfo(anyLong(), any())).thenReturn(operatorInfoDto);

        mockMvc.perform(put("/api/operator/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(operatorInfoDto)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetOperatorInfoById() throws Exception {
        OperatorInfoDto operatorInfoDto = new OperatorInfoDto();
        when(operatorInfoService.getOperatorInfoById(anyLong())).thenReturn(operatorInfoDto);

        mockMvc.perform(get("/api/operator/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteOperatorInfo() throws Exception {
        doNothing().when(operatorInfoService).deleteOperatorInfo(anyLong());

        mockMvc.perform(delete("/api/operator/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testGetAllOperatorInfos() throws Exception {
        List<OperatorInfoDto> operatorInfoList = Arrays.asList(new OperatorInfoDto(), new OperatorInfoDto());
        when(operatorInfoService.getAllOperatorInfos()).thenReturn(operatorInfoList);

        mockMvc.perform(get("/api/operator"))
                .andExpect(status().isOk());
    }
}