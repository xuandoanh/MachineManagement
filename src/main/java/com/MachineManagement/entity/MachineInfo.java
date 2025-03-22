package com.MachineManagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "machine_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MachineInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long machineId;
    
    @Column(name = "machine_name", nullable = false)
    private String machineName;

    @Column(name = "machine_type", nullable = false)
    private String machineType;

    @Column(name = "machine_group_name", nullable = false)
    private String machineGroupName;

    @Column(name = "machine_office", nullable = false)
    private String machineOffice;

    @ManyToOne
    @JoinColumn(name = "groupId", nullable = false)  // Foreign key referencing MachineGroup
    @JsonBackReference("machine-group-ref")
    private MachineGroup machineGroup;

    // @OneToMany(mappedBy = "machineInfo", cascade = CascadeType.ALL)
    // @JsonManagedReference("machine-data-ref")  // ✅ Ensure reference name is unique
    // private List<MachineData> machineData;
}
