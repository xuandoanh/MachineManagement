package com.MachineManagement.mapper;

import com.MachineManagement.dto.UserDto.AccountDto;
import com.MachineManagement.entity.UserEntity.AccountEntity;

public class AccountMapper {
    public static AccountDto mapToDto(AccountEntity account) {
        return new AccountDto(
                account.getId(),
                account.getUserName(),
                account.getPassword(),
                account.getIsLogin(),
                account.getChatHistory()
        );
    }

    public static AccountEntity mapToEntity(AccountDto accountDto) {
        return new AccountEntity(
                accountDto.getId(),
                accountDto.getUserName(),
                accountDto.getPassword(),
                accountDto.getIsLogin(),
                accountDto.getChatHistorys()
        );
    }
}