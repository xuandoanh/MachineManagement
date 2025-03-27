package com.MachineManagement.entity.MachineEntity;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "machine_group")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MachineGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name", nullable = false)
    private String groupName;

    @OneToMany(mappedBy = "machineGroup", cascade = CascadeType.ALL)
    @JsonManagedReference("machine-group-ref")
    private List<MachineInfoEntity> machines;
}
