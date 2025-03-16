package com.MachineManagement.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Time;
import com.fasterxml.jackson.annotation.JsonBackReference;

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
    @JsonBackReference
    private MachineInfo machineInfo;    

    @Column(name = "Date_SQL", nullable = false)
    private Date dateSql;

    @Column(name = "Time_SQL", nullable = false)
    private Time timeSql;

    @Column(name = "Status", nullable = false)
    private int status;

    @Column(name = "Power", nullable = false)
    private int power;

    @Column(name = "OpID", nullable = false)
    private int opId;

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
