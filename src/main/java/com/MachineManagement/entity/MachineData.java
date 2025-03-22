package com.MachineManagement.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "machine_data")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MachineData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relationship with MachineInfo
    @ManyToOne
    @JoinColumn(name = "machine_id", nullable = false) // Foreign key reference
    private MachineInfo machineInfo;

    @Column(name = "datetime_sql", nullable = false)
    private LocalDateTime datetimeSql;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "power", nullable = false)
    private int power;

    // Relationship with OperatorInfo
    @ManyToOne
    @JoinColumn(name = "op_id", nullable = false) // Foreign key reference
    private OperatorInfo operatorInfo;

    @Column(name = "or_code", length = 50)
    private String orCode;

    @Column(name = "dg_code", length = 50)
    private String dgCode;

    @Column(name = "pg_time", nullable = false)
    private int pgTime;

    @Column(name = "part_num", nullable = false)
    private int partNum;

    @Column(name = "step", nullable = false)
    private int step;

    @Column(name = "point", nullable = false)
    private int point;

    @Column(name = "b_code", length = 50)
    private String bCode;
}
