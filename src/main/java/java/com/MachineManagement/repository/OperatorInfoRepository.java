package java.com.MachineManagement.repository;

import java.com.MachineManagement.entity.OperatorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OperatorInfoRepository extends JpaRepository<OperatorInfo, Long> {
}


