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

@Entity
@Table(name = "operator_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperatorInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operatorId;
    
    @Column(name = "operator_name", nullable = false)
    private String operatorName;

    @Column(name = "operator_office", nullable = false)
    private String operatorOffice;

    @Column(name = "operator_section", nullable = false)
    private String operatorSection;

    @Column(name = "operator_step", nullable = false)
    private String operatorStep;

    @ManyToOne
    @JoinColumn(name = "groupId", nullable = false)
    @JsonBackReference("operator-group-ref")
    private OperatorGroup operatorGroup;

    // @OneToMany(mappedBy = "operatorInfo", cascade = CascadeType.ALL)
    // @JsonManagedReference("operator-data-ref")
    // private List<MachineData> machineData;
}
