package java.com.MachineManagement.repository;

import java.com.MachineManagement.entity.MachineInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineInfoRepository extends JpaRepository<MachineInfo, Long> {
}

