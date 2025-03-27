package com.MachineManagement.controller.UserController;

import com.MachineManagement.dto.UserDto.ChatHistoryDto;
import com.MachineManagement.service.UserService.ChatHistoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chatHistory")
public class ChatHistoryController {
    @Autowired
    private ChatHistoryService chatHistoryService;

    @PostMapping("/{accountId}")
    public ResponseEntity<ChatHistoryDto> addChatHistory(@PathVariable Long accountId, @RequestBody ChatHistoryDto chatHistoryDto) {
        return ResponseEntity.ok(chatHistoryService.addChatHistory(accountId, chatHistoryDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatHistoryDto> updateChatHistory(@PathVariable Long id, @RequestBody ChatHistoryDto chatHistoryDto) {
        return ResponseEntity.ok(chatHistoryService.updateChatHistory(id, chatHistoryDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatHistoryDto> getChatHistoryById(@PathVariable Long id) {
        return ResponseEntity.ok(chatHistoryService.getChatHistoryById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChatHistory(@PathVariable Long id) {
        chatHistoryService.deleteChatHistory(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ChatHistoryDto>> getAllChatHistories() {
        return ResponseEntity.ok(chatHistoryService.getAllChatHistories());
    }
}