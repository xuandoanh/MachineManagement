package com.MachineManagement.mapper;

import com.MachineManagement.dto.UserDto.ChatHistoryDto;
import com.MachineManagement.entity.UserEntity.ChatHistoryEntity;

public class ChatHistoryMapper {
    public static ChatHistoryDto mapToDto(ChatHistoryEntity chatHistory) {
        return new ChatHistoryDto(
                chatHistory.getId(),
                chatHistory.getChatText(),
                chatHistory.getType_text(),
                chatHistory.getDatetimeSql(),
                chatHistory.getImage_data(),
                chatHistory.getAccount()
        );
    }

    public static ChatHistoryEntity mapToEntity(ChatHistoryDto chatHistoryDto) {
        return new ChatHistoryEntity(
                chatHistoryDto.getId(),
                chatHistoryDto.getChatText(),
                chatHistoryDto.getType_text(),
                chatHistoryDto.getDatetimeSql(),
                chatHistoryDto.getImage_data(),
                chatHistoryDto.getAccount()
        );
    }
}