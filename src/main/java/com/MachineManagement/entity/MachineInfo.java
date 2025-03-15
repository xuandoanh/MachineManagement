package com.MachineManagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JoinColumn(name = "group_id", nullable = false)  // Foreign key referencing MachineGroup
    @JsonBackReference
    private MachineGroup machineGroup;
}
