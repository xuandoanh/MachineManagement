package com.MachineManagement.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Time;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "CNCtoSQL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MachineData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "machineId", nullable = false)
    @JsonBackReference("machine-data-ref")  // ✅ Ensure reference names match
    private MachineInfo machineInfo;    

    @Column(name = "Date_SQL", nullable = false)
    private Date dateSql;

    @Column(name = "Time_SQL", nullable = false)
    private Time timeSql;

    @Column(name = "Status", nullable = false)
    private int status;

    @Column(name = "Power", nullable = false)
    private int power;

    @ManyToOne
    @JoinColumn(name = "OpId", nullable = false)
    @JsonBackReference("operator-data-ref")  // ✅ Fix: Use a unique reference name
    private OperatorInfo operatorInfo;  

    @Column(name = "OrCode", length = 50)
    private String orCode;

    @Column(name = "DgCode", length = 50)
    private String dgCode;

    @Column(name = "PGTime", nullable = false)
    private int pgTime;

    @Column(name = "PartNum", nullable = false)
    private int partNum;

    @Column(name = "Step", nullable = false)
    private int step;

    @Column(name = "Point", nullable = false)
    private int point;

    @Column(name = "BCode", length = 50)
    private String bCode;
}

