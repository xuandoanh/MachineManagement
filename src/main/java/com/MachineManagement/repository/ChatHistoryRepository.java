package com.MachineManagement.repository;
import com.MachineManagement.entity.UserEntity.ChatHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatHistoryRepository extends JpaRepository<ChatHistoryEntity, Long> {
}
