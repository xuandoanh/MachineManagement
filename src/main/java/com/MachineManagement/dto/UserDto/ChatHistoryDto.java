package com.MachineManagement.dto.UserDto;
 
import lombok.*;
import java.time.LocalDateTime;

import com.MachineManagement.entity.UserEntity.AccountEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatHistoryDto {
    private Long id;
    private String chatText;
    private String type_text;
    private LocalDateTime datetimeSql;
    private int image_data;
    private AccountEntity account;
}
