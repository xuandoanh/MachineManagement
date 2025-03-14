package java.com.MachineManagement.repository;

import java.com.MachineManagement.entity.OperatorGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorGroupRepository extends JpaRepository<OperatorGroup, Long> {
}
