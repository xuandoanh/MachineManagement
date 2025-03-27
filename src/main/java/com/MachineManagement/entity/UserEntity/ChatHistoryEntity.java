package com.MachineManagement.entity.UserEntity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "chat_history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chat_text", nullable = false)
    private String chatText;

    @Column(name = "sender_type", nullable = false) // user or bot
    private String type_text;

    @Column(name = "chat_type", nullable = false) // is image or not
    private LocalDateTime datetimeSql;

    @Column(name = "image_data",columnDefinition = "BLOB") // can be null due to the chat_type
    private int image_data;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private AccountEntity account;
}
