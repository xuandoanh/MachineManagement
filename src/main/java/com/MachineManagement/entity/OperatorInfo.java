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
@Table(name = "operator_info")
public class OperatorInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operatorId;
    
    @Column(name = "operatorName", nullable = false)
    private String operatorName;

    @Column(name = "operatorOffice", nullable = false)
    private String operatorOffice;

    @Column(name = "operatorSection", nullable = false)
    private String operatorSection;

    @Column(name = "operatorStep", nullable = false)
    private String operatorStep;

     @ManyToOne
    @JoinColumn(name = "groupId", nullable = false)  // Foreign key referencing MachineGroup
    @JsonBackReference
    private OperatorGroup operatorGroup;
}
