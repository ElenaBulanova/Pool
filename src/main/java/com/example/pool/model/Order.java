package com.example.pool.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_t")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "duration")
    private Double duration;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    @ManyToOne
    @JoinColumn(name = "table_id")
    PoolTable poolTable;


}
