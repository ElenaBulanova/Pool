package com.example.pool.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "session_t")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start")
    private Date start;

    @Column(name = "finish")
    private Date finish;

//    @Column(name = "sum")
//    private double sum;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    @ManyToOne
    @JoinColumn(name = "table_id")
    PoolTable poolTable;

//    @ManyToOne
//    @JoinColumn(name = "session_fine_id")
//    SessionFines sessionFines;
}
