package com.MachineManagement.service.impl.UserImpl;
import com.MachineManagement.dto.UserDto.AccountDto;
import com.MachineManagement.entity.UserEntity.AccountEntity;
import com.MachineManagement.mapper.AccountMapper;
import com.MachineManagement.repository.AccountRepository;
import com.MachineManagement.service.UserService.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto addAccount(AccountDto accountDto) {
        AccountEntity account = AccountMapper.mapToEntity(accountDto);
        return AccountMapper.mapToDto(accountRepository.save(account));
    }

    @Override
    public AccountDto updateAccount(Long accountId, AccountDto accountDto) {
        AccountEntity account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setUserName(accountDto.getUserName());
        account.setPassword(accountDto.getPassword());
        account.setIsLogin(accountDto.getIsLogin());
        account.setChatHistory(accountDto.getChatHistorys());
        return AccountMapper.mapToDto(accountRepository.save(account));
    }

    @Override
    public AccountDto getAccountById(Long accountId) {
        return accountRepository.findById(accountId)
                .map(AccountMapper::mapToDto)
                .orElse(null);
    }

    @Override
    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(AccountMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
