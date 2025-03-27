package com.MachineManagement.service.UserService;

import com.MachineManagement.dto.UserDto.ChatHistoryDto;
import java.util.List;

public interface ChatHistoryService {
    ChatHistoryDto addChatHistory(Long id, ChatHistoryDto chatHistoryDto);
    ChatHistoryDto updateChatHistory(Long chatHistoryId, ChatHistoryDto chatHistoryDto);
    ChatHistoryDto getChatHistoryById(Long chatHistoryId);
    void deleteChatHistory(Long chatHistoryId);
    List<ChatHistoryDto> getAllChatHistories();
}
