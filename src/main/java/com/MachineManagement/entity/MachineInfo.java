package com.MachineManagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "machine_info")
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
    @JoinColumn(name = "groupId", nullable = false)  // Foreign key referencing MachineGroup
    private MachineGroup machineGroup;

    // ✅ Add OneToMany for MachineData
    @OneToMany(mappedBy = "machineInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<MachineData> machineData;
}
