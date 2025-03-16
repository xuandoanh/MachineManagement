package com.MachineManagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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
    
    @Column(name = "machineName", nullable = false)
    private String machineName;

    @Column(name = "machineType", nullable = false)
    private String machineType;

    @Column(name = "machineGroupName", nullable = false)
    private String machineGroupName;

    @Column(name = "machineOffice", nullable = false)
    private String machineOffice;

    @ManyToOne
    @JsonBackReference("machine-group-ref")
    @JoinColumn(name = "groupId", nullable = false)  // Foreign key referencing MachineGroup
    private MachineGroup machineGroup;

    @OneToMany(mappedBy = "machineInfo", cascade = CascadeType.ALL)
    @JsonManagedReference("machine-data-ref")  // ✅ Ensure reference name is unique
    private List<MachineData> machineData;
}
