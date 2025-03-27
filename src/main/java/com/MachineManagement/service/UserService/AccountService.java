package com.MachineManagement.service.UserService;

import com.MachineManagement.dto.UserDto.AccountDto;
import java.util.List;

public interface AccountService {
    AccountDto addAccount(AccountDto accountDto);
    AccountDto updateAccount(Long accountId, AccountDto accountDto);
    AccountDto getAccountById(Long accountId);
    void deleteAccount(Long accountId);
    List<AccountDto> getAllAccounts();
}
