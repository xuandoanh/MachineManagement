package com.MachineManagement.dto.UserDto;

import java.util.List;

import com.MachineManagement.entity.UserEntity.ChatHistoryEntity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
    private Long id;
    private String userName;
    private String password;
    private int isLogin;
    private List<ChatHistoryEntity> chatHistorys;
}
