package com.MachineManagement.service.impl.UserImpl;
import com.MachineManagement.dto.UserDto.AccountDto;
import com.MachineManagement.dto.UserDto.ChatHistoryDto;
import com.MachineManagement.entity.UserEntity.AccountEntity;
import com.MachineManagement.entity.UserEntity.ChatHistoryEntity;
import com.MachineManagement.mapper.AccountMapper;
import com.MachineManagement.mapper.ChatHistoryMapper;
import com.MachineManagement.repository.AccountRepository;
import com.MachineManagement.repository.ChatHistoryRepository;
import com.MachineManagement.service.UserService.AccountService;
import com.MachineManagement.service.UserService.ChatHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ChatHistoryServiceImpl implements ChatHistoryService {
    @Autowired
    private ChatHistoryRepository chatHistoryRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public ChatHistoryDto addChatHistory(Long accountId, ChatHistoryDto chatHistoryDto) {
        AccountEntity account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        ChatHistoryEntity chatHistory = ChatHistoryMapper.mapToEntity(chatHistoryDto);
        chatHistory.setAccount(account);
        return ChatHistoryMapper.mapToDto(chatHistoryRepository.save(chatHistory));
    }

    @Override
    public ChatHistoryDto updateChatHistory(Long chatHistoryId, ChatHistoryDto chatHistoryDto) {
        ChatHistoryEntity chatHistory = chatHistoryRepository.findById(chatHistoryId)
                .orElseThrow(() -> new RuntimeException("Chat history not found"));
        chatHistory.setChatText(chatHistoryDto.getChatText());
        chatHistory.setType_text(chatHistoryDto.getType_text());
        chatHistory.setDatetimeSql(chatHistoryDto.getDatetimeSql());
        chatHistory.setImage_data(chatHistoryDto.getImage_data());
        return ChatHistoryMapper.mapToDto(chatHistoryRepository.save(chatHistory));
    }

    @Override
    public ChatHistoryDto getChatHistoryById(Long chatHistoryId) {
        return chatHistoryRepository.findById(chatHistoryId)
                .map(ChatHistoryMapper::mapToDto)
                .orElse(null);
    }

    @Override
    public void deleteChatHistory(Long chatHistoryId) {
        chatHistoryRepository.deleteById(chatHistoryId);
    }

    @Override
    public List<ChatHistoryDto> getAllChatHistories() {
        return chatHistoryRepository.findAll()
                .stream()
                .map(ChatHistoryMapper::mapToDto)
                .collect(Collectors.toList());
    }

}